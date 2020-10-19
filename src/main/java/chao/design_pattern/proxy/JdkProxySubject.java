package chao.design_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName JdkProxySubjectImpl.java
 * @Description TODO
 * @createTime 2020年06月27日 13:38:00
 */
public class JdkProxySubject<T> implements InvocationHandler {

    private T object;

    public JdkProxySubject(T object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我想在执行真实方法前做一些处理···By JdkProxy");
        Object invoke = method.invoke(object, args);//执行真正的方法
        System.out.println("我想在执行真实方法后做一些处理···By JdkProxy");
        return invoke;
    }

    public <T> T getProxy() {
        //第一个参数是指定代理类的类加载器（我们传入当前测试类的类加载器）
        //第二个参数是代理类需要实现的接口（我们传入被代理类实现的接口，这样生成的代理类和被代理类就实现了相同的接口）
        //第三个参数是invocation handler，用来处理方法的调用。这里传入我们自己实现的handler
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }
}
