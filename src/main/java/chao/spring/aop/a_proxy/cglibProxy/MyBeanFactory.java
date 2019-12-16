package chao.spring.aop.a_proxy.cglibProxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {

	public static UserService createService() {
		// 1、目标类
		UserService userService = new UserService();
		// 2、切面类
		MyAspect aspect = new MyAspect();
		// 3、代理类，采用cglib，底层创建目标类的子类
		//3.1、 核心类
		Enhancer enhancer = new Enhancer();
		//3.2、确定父类
		enhancer.setSuperclass(userService.getClass());
		/*3.3、设置回调函数Callback,MethodInterceptor接口等效jdk InvocationHandler接口
		 * ·intercept()等效jdk中 invoke()
		 * 	参数1、参数2、参数3：与invoke()一样
		 * 	参数4：方法的代理
		 * */
		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				
				//前
				aspect.before();
				//执行目标类的方法
//				Object invoke = method.invoke(userService, args);
				//执行代理类的父类，相当于执行目标类（目标类与代理类 父子关系）
				Object invoke = methodProxy.invokeSuper(proxy, args);
				//后
				aspect.after();
				return invoke;
			}});
		//3.4创建代理
		UserService userServiceProxy = (UserService) enhancer.create();
		return userServiceProxy;
	}
}
