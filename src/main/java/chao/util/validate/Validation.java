package chao.util.validate;

import java.util.function.Function;

/**
 * @author chao.guo
 * @Description TODO
 * @create 2020/08/31 20:34:00
 */
@FunctionalInterface
public interface Validation {

    boolean validate(String name, String value);
}
