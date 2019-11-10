package test.spring.aop.d_aspect.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 切面类,含有多个通知
 */
public class MyAspect {

	//前置通知
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("前置通知:" + joinPoint.getSignature().getName());
	}
	
	//后置通知
	public void myAfterReturning(JoinPoint joinPoint, Object ret) {
		System.out.println("后置通知：" + joinPoint.getSignature().getName() + "->" + ret);
	}
	
	//环绕通知
	public Object myArund(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕通知-前:");
		Object obj = joinPoint.proceed();
		System.out.println("环绕通知-后:");
		return obj;
	}
	
	//抛出异常通知
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("抛出异常通知:" + e.getMessage());
	}
	
	//最终通知
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("最终通知");
	}
}
 