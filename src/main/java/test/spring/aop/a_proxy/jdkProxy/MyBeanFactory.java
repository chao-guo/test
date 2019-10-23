package test.spring.aop.a_proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

	public static UserService createService() {
		// 目标类
		UserService userService = new UserServiceImpl();
		// 切面类
		MyAspect aspect = new MyAspect();
		/*
		 * 代理类 
		 * 	参数1：loader，类加载器，动态代理类，运行时创建，任何类都需要类加载器将其加载到内存。
		 * 		一般情况：当前类.class.getClassLoader(); 
		 * 		或者目标类实例.calss.getClassLoader 
		 * 	参数2：Class[] interfaces 代理类需要实现的所有接口 
		 * 		方式1：目标类.getClass().getInterfaces() 
		 * 		方式2：new Class[]{UserService.class} 
		 * 		例如：jdbc驱动 --> DriverManager 获得接口Connection
		 * 	参数3：InvocationHandler 处理类，接口，必须进行实现类，一般采用匿名内部类
		 * 		提供invoke方法，代理类的每一个方法执行时，都将调用一次invoke
		 * 			参数3.1：Object proxy 代理对象
		 * 			参数3.2：Method method 代理对象当前执行的方法的描述对象（反射）
		 * 				执行方法名：method.getName()
		 * 				执行方法：method.invoke(对象，实际参数)
		 * 			参数3.3：Object[] args 方法实际参数
		 */
		UserService userServiceProxy = (UserService) Proxy.newProxyInstance(
				MyBeanFactory.class.getClassLoader(),
				userService.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//前
						aspect.before();
						//执行目标类的方法
						Object invoke = method.invoke(userService, args);
						//后
						aspect.after();
						return invoke;
					}
				});
		return userServiceProxy;
	}
}
