package com.douzone.container.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User1;

public class TestContainer {

	public static void main(String[] args) {
		
		testApplicationContext01();
		testApplicationContext02();
		
	}

	// XML Auto-Configuration(Annotation Scanning) 자동설정
	public static void testApplicationContext01() {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/user/applicationContext1.xml");
		
		User1 user1=appContext.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean의 id가 자동으로 설정 
		user1=(User1)appContext.getBean("user1");
		System.out.println(user1.getName());
	}
	
	// XML Bean Configuration(Implicit Configuration) 명시적 설정 
		public static void testApplicationContext02() {
			
			ApplicationContext appContext = new ClassPathXmlApplicationContext("config/user/applicationContext2.xml");
			
			User1 user1=appContext.getBean(User1.class);
			System.out.println(user1.getName());
			
			// Bean의 id가 자동으로 설정 
			user1=(User1)appContext.getBean("user1");
			System.out.println(user1.getName());
		}
	
	
	
}
