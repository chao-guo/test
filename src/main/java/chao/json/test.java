package chao.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class test {

	public static void main(String[] args) {
		/*
		 * Address address = new Address(); address.setName("陕西");
		 * address.setLocation("中国"); List<Car> cars = new ArrayList<Car>();
		 * cars.add(new Car("1", "A")); cars.add(new Car("2", "B")); Person person = new
		 * Person(); person.setName("红"); person.setCardId(1);
		 * person.setAddress(address); person.setCars(cars); // JSONArray fromObject1 =
		 * JSONArray.fromObject(person); // System.out.println(fromObject1); // String a
		 * =
		 * "[{\"address\":{\"location\":\"中国\",\"name\":\"陕西\"},\"cardId\":1,\"cars\":[{\"brand\":\"A\",\"name\":\"1\"},{\"brand\":\"B\",\"name\":\"2\"}],\"name\":\"红\"}]\r\n"
		 * + // ""; String jsonString = JSON.toJSONString(person);
		 * System.out.println(jsonString); String a =
		 * "{\"address\":{\"location\":\"中国\",\"name\":\"陕西\"},\"cardId\":1,\"cars\":[{\"brand\":\"A\",\"name\":\"1\"},{\"brand\":\"B\",\"name\":\"2\"}],\"name\":\"红\"}\r\n"
		 * + ""; Person parseObject = JSON.parseObject(a,Person.class);
		 * System.out.println(a);
		 */

		String pipeProject = "[{\"crtDate\":1577018631000,\"crtUserId\":\"admin\",\"crtUserName\":\"admin\",\"dataLocations\":[{\"dataLocationCode\":\"rtdb\",\"dataLocationId\":200,\"dataLocationName\":\"rtdb\",\"dataPoolCode\":\"rtdb\",\"dataRoot\":2,\"meteModelNodeCode\":\"fms.ceshi.zong\",\"partitionCode\":\"jicheng\",\"pipeProjectCode\":\"1211\",\"sizeX\":1,\"sizeY\":1},{\"dataLocationCode\":\"2\",\"dataLocationId\":201,\"dataLocationName\":\"2\",\"dataPoolCode\":\"2\",\"dataRoot\":1,\"meteModelNodeCode\":\"fms.ceshi.zong\",\"partitionCode\":\"jicheng\",\"pipeProjectCode\":\"1211\",\"sizeX\":1,\"sizeY\":1}],\"dataPipes\":[{\"crtDate\":1577018631000,\"crtUserId\":\"admin\",\"crtUserName\":\"admin\",\"dataPipeCode\":\"1211\",\"dataPipeId\":82,\"dataPipeName\":\"1211\",\"dataPumpTemplateCode\":\"test\",\"enabled\":0,\"mntDate\":1577018632000,\"mntUserId\":\"admin\",\"mntUserName\":\"admin\",\"paramValues\":[{\"dataPipeCode\":\"1211\",\"paramCode\":\"124\",\"paramValueCode\":\"1211\",\"paramValueId\":73,\"paramerValue\":\"[{\\\"factoryCode\\\":\\\"fms.ceshi.zong\\\"}]\",\"parameterValue\":\"[{\\\"factoryCode\\\":\\\"fms.ceshi.zong\\\"}]\",\"pipeProjectCode\":\"1211\"}],\"pipeProjectCode\":\"1211\",\"skip\":0,\"sort\":0,\"targetPoolCode\":\"2\"}],\"enabled\":0,\"mntDate\":1577018631000,\"mntUserId\":\"admin\",\"mntUserName\":\"admin\",\"pipeProjectCode\":\"1211\",\"pipeProjectId\":113,\"pipeProjectName\":\"12112\",\"skip\":0,\"sort\":0,\"status\":0,\"topologyCode\":\"local_storm_instance_15770184685010\"}]";
		JSONArray jsonObj = JSON.parseArray(pipeProject);
		List<TopoPump> pumpList = new ArrayList<TopoPump>();
		Iterator<Object> iterator = jsonObj.iterator();
		while (iterator.hasNext()) {
			JSONObject next = (JSONObject) iterator.next();
			TopoPump pump = new TopoPump();
			pump.setDataPumpCode(next.getString("pipeProjectCode"));
			pump.setDataPumpName(next.getString("pipeProjectName"));
			pump.setDataPumpStatus(Integer.parseInt(next.getString("status")));
			JSONArray dataPipes = JSON.parseArray(next.getString("dataPipes"));
			JSONObject dataPipe = (JSONObject) dataPipes.get(0);
			JSONArray paramValues = JSON.parseArray(dataPipe.getString("paramValues"));
			JSONObject paramValue = (JSONObject) paramValues.get(0);
			JSONArray parameterValues = JSON.parseArray(paramValue.getString("parameterValue"));
			JSONObject parameterValue = (JSONObject) parameterValues.get(0);
			pump.setFactoryCode(parameterValue.getString("factoryCode"));
			pumpList.add(pump);
		}
	}
}
