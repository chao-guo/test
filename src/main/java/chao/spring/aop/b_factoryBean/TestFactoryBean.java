package chao.spring.aop.b_factoryBean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {

	@Test
	public void demo() {

		String xmlPath ="beans.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("proxyServiceId");
		userService.addUser();
		userService.deleteUser();
		userService.updateUser();
		applicationContext.close();
	}
}
