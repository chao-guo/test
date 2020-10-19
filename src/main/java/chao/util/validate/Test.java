package chao.util.validate;

import chao.dataandc.test.Student;
import chao.extendsInterface.A;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/08/31 20:38:00
 */
public class Test {

    // 匹配由数字、26个英文字母或者下划线组成的字符串
    public static final String regexForCode = "^[0-9a-zA-Z_]{1,}$";

    public static void main(String[] args) {
        Student student = Student.createStudent("张三@", 1);

        Map<String, ValidateInfo> validateInfoMap = new HashMap<>();
        validateInfoMap.put("name", new ValidateInfo((name, value) -> {
            return StringUtils.isNotEmpty(value) ? value.trim().matches(regexForCode) ? true : false : false;
        }, "name格式错误"));
//        validations.put("name", (name, value, messsage) -> {
//
//        });
    }
}
