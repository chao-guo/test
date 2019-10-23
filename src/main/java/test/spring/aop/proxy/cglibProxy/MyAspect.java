package test.spring.aop.proxy.cglibProxy;

public class MyAspect {

	public void before() {
		System.out.println("aop.proxy aspect before");
	}
	
	public void after() {
		System.out.println("aop.proxy aspect after");
	}
}
