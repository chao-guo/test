package chao.spring.aop.a_proxy.jdkProxy;

import org.junit.Test;

public class TestJDKProxy {

	public static void main(String[] args) {

		UserService userService = MyBeanFactory.createService();
		userService.addUser();
		userService.deleteUser();
		userService.updateUser();
	}
}
