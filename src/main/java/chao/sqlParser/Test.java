package chao.sqlParser;

import java.util.List;

public class Test {
    /** *//**
    * 单句Sql解析器制造工厂
    * @author 赵朝峰
    *
    * @since 2013-6-10
    * @version 1.00
    */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       //String test="select  a from  b " +
           //    "\n"+"where      a=b";
       //test=test.replaceAll("\\s{1,}", " ");
       //System.out.println(test);
       //程序的入口
        String testSql="select c1,c2,c3     from    t1,t2 where condi3=3 "+"\n"+"    or condi4=5 order by o1,o2";

        String sql = "select `content`.`t_content`.`content_code` AS `content_code`," +
                "`content`.`t_content`.`content_name` AS `content_name`," +
                "`content`.`t_content`.`rent_app_id` AS `rent_app_id`," +
                "`content`.`t_content`.`crt_user_id` AS `crt_user_id`,`content`.`t_content`.`crt_user_name` AS `crt_user_name`" +
                ",`content`.`t_content`.`crt_date` AS `crt_date`,`content`.`t_content`.`mnt_user_id` AS `mnt_user_id`," +
                "`content`.`t_content`.`mnt_user_name` AS `mnt_user_name`,`content`.`t_content`.`mnt_date` AS `mnt_date`" +
                ",`content`.`t_content_item`.`item_id` AS `item_id`,`content`.`t_content_item`.`content_id` AS `content_id`" +
                ",`content`.`t_content_item`.`data_pool_code` AS `data_pool_code`,`content`.`t_content_item`.`data_pool_type`" +
                " AS `data_pool_type`,`content`.`t_content_item`.`type` AS `type`,`content`.`t_content_item`.`associated_fields`" +
                " AS `associated_fields`,`content`.`t_content_item`.`datasource_id` AS `datasource_id` from " +
                "`content`.`t_content` join `content`.`t_content_item`";
        SqlParserUtil test=new SqlParserUtil();
//        String result=test.getParsedSql(testSql);
        List<SqlSegment> result=test.getParsedSqlList(sql);//保存解析结果
        result.forEach(i -> {
        	System.out.println(i.getBody());
        });
//        System.out.println(result);
    }

}