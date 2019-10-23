package test.spring.aop.proxy.jdkProxy;

import org.junit.Test;

public class TestJDKProxy {

	@Test
	public void demo() {

		UserService userService = MyBeanFactory.createService();
		userService.addUser();
		userService.deleteUser();
		userService.updateUser();
	}
}
