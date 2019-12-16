package chao.spring.aop.d_aspect.annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectAnno {

	@Test
	public void demo() {

		String xmlPath ="beans_aspect_anno.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
		userService.deleteUser();
		userService.updateUser();
		applicationContext.close();
	}
}
