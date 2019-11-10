package test.spring.aop.d_aspect.xml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectXml {

	@Test
	public void demo() {

		String xmlPath ="beans_aspect_xml.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
		userService.deleteUser();
		userService.updateUser();
		applicationContext.close();
	}
}
