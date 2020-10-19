package chao.design_pattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName CGlibProxySubject.java
 * @Description TODO
 * @createTime 2020年06月27日 19:04:00
 */
public class CGlibProxySubject<T> implements MethodInterceptor {

    private T object;

    public CGlibProxySubject(T object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我想在执行真实方法前做一些处理···By CGlib");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("我想在执行真实方法后做一些处理···By CGlib");
        return result;
    }

    public <T> T getProxy() {
        Enhancer enhancer = new Enhancer();
        //设置被代理类
        enhancer.setSuperclass(object.getClass());
        //设置回调
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }
}
