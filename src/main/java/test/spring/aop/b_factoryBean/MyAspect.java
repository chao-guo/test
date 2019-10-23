package test.spring.aop.b_factoryBean;

public class MyAspect {

	public void before() {
		System.out.println("aop.proxy aspect before");
	}
	
	public void after() {
		System.out.println("aop.proxy aspect after");
	}
}
