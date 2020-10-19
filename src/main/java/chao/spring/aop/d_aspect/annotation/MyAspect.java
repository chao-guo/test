package chao.spring.aop.d_aspect.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 切面类,含有多个通知
 */
@Component("myAspectId")
@Aspect
public class MyAspect {

	//前置通知
	//切入点仅当前有效
//	@Before("execution(* test.spring.myaop.d_aspect.annotation.UserServiceImpl.*(..))")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("前置通知:" + joinPoint.getSignature().getName());
	}
	
	//声明公共切入点
	@Pointcut("execution(* test.spring.aop.d_aspect.annotation.UserServiceImpl.*(..))")
	private void myPointCut() {
	}
	
	//后置通知
//	@AfterReturning(value = "myPointCut()", returning = "ret")
	public void myAfterReturning(JoinPoint joinPoint, Object ret) {
		System.out.println("后置通知：" + joinPoint.getSignature().getName() + "->" + ret);
	}
	
	//环绕通知
//	@Around("myPointCut()")
	public Object myArund(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕通知-前:");
		Object obj = joinPoint.proceed();
		System.out.println("环绕通知-后:");
		return obj;
	}
	
	//抛出异常通知
//	@AfterThrowing(value = "myPointCut()", throwing = "e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("抛出异常通知:" + e.getMessage());
	}
	
	//最终通知
	@After(value = "myPointCut()") 
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("最终通知");
	}
}
 