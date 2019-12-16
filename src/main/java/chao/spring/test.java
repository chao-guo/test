package chao.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chao.spring.service.AppService;

public class test {
	
	@Test
	public void demo() throws Exception {

		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		AppService appService = (AppService) applicationContext.getBean("appService");
		appService.addApp();
		applicationContext.getClass().getMethod("close").invoke(applicationContext);
	}
}
