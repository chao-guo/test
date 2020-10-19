package chao.sqlParser.other;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.util.JdbcConstants;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/07/31 19:46:00
 */


public final class SqlFileExecutor {

    public static void main(String[] args) {
        try {
            List<String> sqlList = new SqlFileExecutor().loadSql("D:\\Coder\\eclipse-workspace\\test\\src\\main\\resources\\SMES.sql");
            System.out.println("size:" + sqlList.size());
            for (String sql : sqlList) {
                System.out.println(sql);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * 读取 SQL 文件，获取 SQL 语句
     *
     * @param sqlFile SQL 脚本文件
     * @return List<sql> 返回所有 SQL 语句的 List
     * @throws Exception
     */
    private List<String> loadSql(String sqlFile) throws Exception {
        List<String> sqlList = new ArrayList<String>();
        try {
            InputStream sqlFileIn = new FileInputStream(sqlFile);
            StringBuffer sqlSb = new StringBuffer();
            byte[] buff = new byte[1024];
            int byteRead = 0;
            while ((byteRead = sqlFileIn.read(buff)) != -1) {
                sqlSb.append(new String(buff, 0, byteRead));
            }

            List<String> strings = parseSql(sqlSb);
            createTable(strings.get(0));
            return sqlList;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    List<String> parseSql(StringBuffer sql) {
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<Character>();
        int k = 0;
        int start = 0;
        for (int i = 0; i < sql.length(); i++) {
            char c = sql.charAt(i);
            if (c == '(') {
                stack.push('(');
                k++;
            }
            if (c == ')') {
                Character pop = stack.pop();
                k--;
                if (k == 0) {
                    String substring = sql.substring(start, i + 1);
                    result.add(substring);
                    start = i + 1;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    void createTable(String sql) {
        int create_table_ = sql.lastIndexOf("CREATE TABLE ");
        int i = sql.indexOf("(");
        int i1 = sql.lastIndexOf(")");
        String tableName = sql.substring(create_table_ + "CREATE TABLE ".length(), i).trim().replaceAll("\r", "").replaceAll("\n", "");
        String substring = sql.substring(i + 1, i1 - 1).trim().replaceAll("\r", "").replaceAll("\n", "");
        String[] split = substring.split(",");
        System.out.println(split);
    }


}
