package chao.spring.aop.c_spring_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
 * 切面类中确定通知，需要实现不同接口，接口就是规范，从而就确定方法名称。
 * 采用“环绕通知” MethodInterceptor
 */
public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("-------aop.spring_aop aspect before-------");
		//手动执行目标方法
		Object obj = invocation.proceed();
		System.out.println("-------aop.spring_aop aspect after-------");
		return obj;
	}
}
