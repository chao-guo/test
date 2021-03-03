package chao.util.reflect.invoker;

import java.lang.reflect.InvocationTargetException;

/**
 * @author chao.guo
 * @Date 2020/11/9 10:09
 */
public interface Invoker {
    //调用
    Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException;

    //取得类型
    Class<?> getType();
}
