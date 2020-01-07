package chao.other.model;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import pcitc.imp.common.ettool.utils.RestfulTool;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoService {

    public static void main(String[] args) {

        @SuppressWarnings("unused")
		String[] arg = {"10.110.3.82:8099",
                        "fms.qlsh",
                        "10.110.3.75:8080",
                        "",
                        "",
                        "qlrtdbpool",
                        "pump_1570686747218",
                        "",
                        "log.log"};
        String[] argteset = {"10.238.221.137:8099",
                "pm.wsm.lysh",
                "10.238.221.85:8081",
                "",
                "",
                "RTDB_test",
                "pump_1573803035301",
                "",
                "D:\\log.log"};
        try {
			updateAgentlet(argteset);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static void updateAgentlet(String[] args) throws Exception {
        //工厂模型地址
        String fmsHost = args[0];
        //工厂模型租户
        String fmsRent = args[1];
        //订阅服务地址
        String subHost = args[2];
        //agentlet编辑器后台地址
        String editorHost = args[3];
        //agent定义服务地址
        String agentHost = args[4];
        //数据池编码
        String dataPoolCode = args[5];
        //数据泵编码
        String dataPumpCode = args[6];
        //罐量计算类型编码
        String typeCode = args[7];
        //记录相关信息输出文件路径
        String outFile = args[8];
        File out = new File(outFile);

        //所有罐
        String bodyAsString = Transfer.get("http://" + fmsHost + "/FactoryModelService/rents/" + fmsRent + "/tanks");
        List<Tank> tankList = (List<Tank>) RestfulTool.toResourceRepList(bodyAsString, Tank.class);

        //所有智能点信息
        List<AgentDefine> agentDefineList = RestfulTool.toResourceRepList(Transfer.get("http://" + agentHost + "/agentService/apps/ICT/agentletTypes/" + typeCode + "/agentlets"), AgentDefine.class);
        //所有订阅信息
        List<Subscribe> subscribeList = RestfulTool.toResourceRepList(Transfer.get("http://" + subHost + "/subscribeService/subscribes"), Subscribe.class);

        //所有度量指标
        List<Measurement> measurementList = RestfulTool.toResourceRepList(Transfer.get("http://" + fmsHost + "/FactoryModelService/rents/" + fmsRent + "/measurements"), Measurement.class);

        //罐编码-->度量指标
        Map<String, List<Measurement>> listMap = new HashMap<>();
        for (Measurement m2 : measurementList) {
            if (listMap.containsKey(m2.getNodeCode())) {
                List<Measurement> measurements = listMap.get(m2.getNodeCode());
                measurements.add(m2);
                listMap.put(m2.getNodeCode(), measurements);
            } else {
                List<Measurement> measurements = new ArrayList<>();
                measurements.add(m2);
                listMap.put(m2.getNodeCode(), measurements);
            }
        }

        //罐总数
        int i = 0;
        //更新数
        int j = 0;
        //新增数
        int k = 0;


        //记录有agentlet且度量指标没有更新的罐
        List<String> tankCodeList = new ArrayList<>();
        //记录没有度量指标且没有订阅的罐
        List<String> tankEmptyIdxList = new ArrayList<>();
        //记录没有度量指标但是有订阅的罐，//TODO:这种情况需要做删除操作，代码里暂时没有，可以修改代码或者手动删除
        List<String> tankEmptyIdxHasSubList = new ArrayList<>();


        //一般情况不会有以下两种罐
        //记录有agentlet没订阅的罐
        List<String> tankEmptySubList = new ArrayList<>();
        //记录没有agentlet有订阅的罐
        List<String> tankEmptyAgentList = new ArrayList<>();

        //记录更新的罐
        //更新失败
        List<String> tankFailPutList = new ArrayList<>();
        //更新失败返回信息
        List<String> tankFailPutMessageList = new ArrayList<>();
        //更新成功
        List<String> tankSuccPutList = new ArrayList<>();
        //更新成功返回信息
        List<String> tankSuccPutMessageList = new ArrayList<>();
        //更新异常
        List<String> tankPutExceptionList = new ArrayList<>();
        //更新异常信息
        List<String> tankPutExceptionMessageList = new ArrayList<>();

        //记录新增的罐
        //新增失败
        List<String> tankFailPostList = new ArrayList<>();
        //新增失败信息
        List<String> tankFailPostMessageList = new ArrayList<>();
        //新增成功
        List<String> tankSuccPostList = new ArrayList<>();
        //新增成功信息
        List<String> tankSuccPostMessageList = new ArrayList<>();
        //新增异常
        List<String> tankPostExceptionList = new ArrayList<>();
        //新增异常信息
        List<String> tankPostExceptionMessageList = new ArrayList<>();

        //记录有订阅没有订阅明细的罐，一般情况下没有
        List<String> tankHasSubAndNotItemList = new ArrayList<>();

        //其他数据源类型的度量指标
        List<String> idxQitaSourceList = new ArrayList<>();

        for (Tank tank : tankList) {
            String nodeCode = tank.getNodeCode();
            try {
                System.out.println("T******T: " + i);

                Subscribe subscribe = getSub(subscribeList, nodeCode);
                AgentDefine agentDefine = getAgent(agentDefineList, nodeCode);
                List<Measurement> measurements = new ArrayList<>();
                if (listMap.containsKey(nodeCode)) {
                    measurements = listMap.get(nodeCode);
                }
                if (measurements == null || measurements.size() == 0) {
                    if (subscribe == null) {
                        tankEmptyIdxList.add(nodeCode);
                    } else {
                        tankEmptyIdxHasSubList.add(nodeCode);
                    }
                } else {
                    for (Measurement measurement : measurements) {
                        //记录数据源类型 有问题的度量指标
                        if (!"RTDB".equalsIgnoreCase(measurement.getSourceDataType()) && !"LIMS".equalsIgnoreCase(measurement.getSourceDataType())) {
                            idxQitaSourceList.add(measurement.getIdxCode());
                            break;
                        }
                    }
                    if (agentDefine != null && subscribe != null) {
                        //agentlet已存在，判断是否需要更新
                        //判断依据是订阅明细中的度量指标信息是否相同
                        //信息包含度量指标编码，数据池编码和指针编码，指针编码是度量指标编码+数据泵编码
                        List<SubscribeItem2> subscribeItem2s = RestfulTool.toResourceRepList(Transfer.get("http://" + subHost + "/subscribeService/subscribes/" + subscribe.getSubscribeCode() + "/subscribeItems"), SubscribeItem2.class);
                        if (subscribeItem2s.size() == 0) {
                            tankHasSubAndNotItemList.add(nodeCode);
                        } else {
                            Set<String> meaItemCodes = new HashSet<>();
                            Set<String> subItemCodes = new HashSet<>();
                            for (SubscribeItem2 item2 : subscribeItem2s) {
                                SubscribeObj subscribeObj = JSONObject.parseObject(item2.getSubscribeObj(), SubscribeObj.class);
                                subItemCodes.add(subscribeObj.getMeasureCode());
                                if ("RTDB".equals(item2.getDataSourceCode())) {
                                    subItemCodes.add(subscribeObj.getCollectionName());
                                    subItemCodes.add(subscribeObj.getPointerCode());
                                }
                            }
                            meaItemCodes.add(dataPoolCode);
                            for (Measurement m : measurements) {
                                if ("RTDB".equalsIgnoreCase(m.getSourceDataType())) {
                                    meaItemCodes.add(m.getIdxCode());
                                    meaItemCodes.add(dataPumpCode + m.getIdxCode());
                                } else if ("LIMS".equalsIgnoreCase(m.getSourceDataType())) {
                                    meaItemCodes.add(m.getIdxCode());
                                }
                            }
                            if (!meaItemCodes.equals(subItemCodes)) {
                                //更新agentlet
                                String name = agentDefine.getAgentletName();
                                //去除名称中的所有特殊字符
                                String regEx="[`~!@#$%^&*()+=\\-|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
                                Pattern p = Pattern.compile(regEx);
                                Matcher m = p.matcher(name);
                                name = m.replaceAll("").trim();
                                agentDefine.setAgentletName(name);

                                List<AgentDefine> agentDefinePutList = new ArrayList<>();
                                agentDefinePutList.add(agentDefine);
                                String re = "";
                                try {
                                    Long a = System.currentTimeMillis();
                                    re = Transfer.put("http://" + editorHost + "/ICT/TankVolume/NewTankVolume/" + agentDefine.getAgentletCode(), RestfulTool.buildCollection(agentDefinePutList));
                                    if (re.contains("error")) {
                                        j ++;
                                        tankFailPutList.add(nodeCode);
                                        tankFailPutMessageList.add(re.replaceAll("\r\n", ""));
                                        System.out.println(j + "FAIL******PUT: " + re.replaceAll("\r\n", ""));
                                    } else {
                                        tankSuccPutList.add(nodeCode);
                                        tankSuccPutMessageList.add(re.replaceAll("\r\n", ""));
                                    }
                                    Long b = System.currentTimeMillis();
                                    System.out.println("TIME******PUT: " + (b - a));
                                } catch (Exception e) {
                                    tankPutExceptionList.add(nodeCode);
                                    tankPutExceptionMessageList.add(e.getMessage());
                                }
                            } else {
                                tankCodeList.add(nodeCode);
                            }
                        }
                    } else if (agentDefine == null && subscribe == null) {
                        //新增agentlet
                        List<AgentDefine> agentDefinePostList = new ArrayList<>();
                        //把罐简称作为agentlet名称
                        String name = tank.getNodeAlias();
                        //去除名称中的所有特殊字符
                        String regEx="[`~!@#$%^&*()+=\\-|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
                        Pattern p = Pattern.compile(regEx);
                        Matcher m = p.matcher(name);
                        name = m.replaceAll("").trim();

                        agentDefine = new AgentDefine();
                        agentDefine.setAgentletName(name);
                        agentDefine.setTypeCode(typeCode);
                        agentDefine.setTreeCode(nodeCode);
                        agentDefine.setTreeType("tank");
                        agentDefine.setFrequency(1);
                        agentDefine.setInUse(1);
                        agentDefine.setDescs("");
                        agentDefine.setOffset(0L);
                        agentDefine.setCrtUser("admin");
                        agentDefine.setMntUser("admin");
                        agentDefinePostList.add(agentDefine);
                        String re = "";
                        try {
                            Long a = System.currentTimeMillis();
                            re = Transfer.post("http://" + editorHost + "/ICT/TankVolume/NewTankVolume", RestfulTool.buildCollection(agentDefinePostList));
                            if (re.contains("error")) {
                                k ++;
                                tankFailPostList.add(nodeCode);
                                tankFailPostMessageList.add(re.replaceAll("\r\n", ""));
                                System.out.println(k + "FAIL******POST: " + re.replaceAll("\r\n", ""));
                            } else {
                                tankSuccPostList.add(nodeCode);
                                tankSuccPostMessageList.add(re.replaceAll("\r\n", ""));
                            }
                            Long b = System.currentTimeMillis();
                            System.out.println("TIME******POST: " + (b - a));
                        } catch (Exception e) {
                            tankPostExceptionList.add(nodeCode);
                            tankPostExceptionMessageList.add(e.getMessage());
                        }
                    } else {
                        //记录agentlet或订阅信息为空的罐
                        if (agentDefine == null) {
                            tankEmptyAgentList.add(nodeCode);
                        } else if (subscribe == null) {
                            tankEmptySubList.add(nodeCode);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            i ++;
        }
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        FileUtils.write(out,
                "正常agentlet:" + "\n"
                        + StringUtils.join(tankCodeList, ",") + "\n"
                        + "没有度量指标的罐:" + "\n"
                        + StringUtils.join(tankEmptyIdxList, ",") + "\n"
                        + StringUtils.join(tankEmptyIdxHasSubList, ",") + "\n"
                        + "没有AGENT或订阅的罐:" + "\n"
                        + StringUtils.join(tankEmptySubList, ",") + "\n"
                        + StringUtils.join(tankEmptyAgentList, ",") + "\n"
                        + "更新AGENT的罐:" + "\n"
                        + StringUtils.join(tankFailPutList, ",") + "\n"
                        + StringUtils.join(tankFailPutMessageList, "|") + "\n"
                        + StringUtils.join(tankSuccPutList, ",") + "\n"
                        + StringUtils.join(tankSuccPutMessageList, "|") + "\n"
                        + StringUtils.join(tankPutExceptionList, ",") + "\n"
                        + StringUtils.join(tankPutExceptionMessageList, "|") + "\n"
                        + "新增AGENT的罐:" + "\n"
                        + StringUtils.join(tankFailPostList, ",") + "\n"
                        + StringUtils.join(tankFailPostMessageList, "|") + "\n"
                        + StringUtils.join(tankSuccPostList, ",") + "\n"
                        + StringUtils.join(tankSuccPostMessageList, "|") + "\n"
                        + StringUtils.join(tankPostExceptionList, ",") + "\n"
                        + StringUtils.join(tankPostExceptionMessageList, "|") + "\n"

                        + StringUtils.join(tankHasSubAndNotItemList, ",") + "\n"
                        + StringUtils.join(idxQitaSourceList, ",") + "\n"
                , "UTF-8", true);
        System.out.println("end");
    }


    public static Subscribe getSub(List<Subscribe> subscribeList, String nodeCode) {
        for (Subscribe subscribe : subscribeList) {
            if (subscribe.getSubscribeCode().contains(nodeCode)) {
                return subscribe;
            }
        }
        return null;
    }

    public static AgentDefine getAgent(List<AgentDefine> agentDefineList, String nodeCode) {
        for (AgentDefine agentDefine : agentDefineList) {
            if (nodeCode.equalsIgnoreCase(agentDefine.getTreeCode())) {
                return agentDefine;
            }
        }
        return null;
    }
}
