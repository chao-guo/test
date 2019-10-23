package test.spring.aop.b_factoryBean;

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
