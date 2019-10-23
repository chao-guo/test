package test.spring.aop.proxy.cglibProxy;

import org.junit.Test;

public class TestCGLIB {

	@Test
	public void demo() {

		UserService userService = MyBeanFactory.createService();
		userService.addUser();
		userService.deleteUser();
		userService.updateUser();
	}
}
