package chao.spring.aop.a_proxy.jdkProxy;

public class MyAspect {

	public void before() {
		System.out.println("myaop.proxy aspect before");
	}
	
	public void after() {
		System.out.println("myaop.proxy aspect after");
	}
}
