package chao.spring.aop.c_spring_aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAop {

	@Test
	public void demo() {

		String xmlPath ="beans_spring_aop.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
		userService.deleteUser();
		userService.updateUser();
		applicationContext.close();
	}
}
