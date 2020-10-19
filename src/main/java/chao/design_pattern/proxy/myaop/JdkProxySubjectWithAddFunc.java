package chao.design_pattern.proxy.myaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName JdkProxySubjectWithAddFunc.java
 * @Description TODO
 * @createTime 2020年06月27日 22:46:00
 */
public class JdkProxySubjectWithAddFunc<T> implements InvocationHandler {

    private T target;

    private AdditionalFunction additionalFunction;

    public JdkProxySubjectWithAddFunc(T target, AdditionalFunction additionalFunction) {
        this.target = target;
        this.additionalFunction = additionalFunction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        additionalFunction.before();
        Object invoke = method.invoke(target, args);
        additionalFunction.after();
        return invoke;
    }

    public <T> T proxy() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
