package com.ysy;

import com.ysy.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shanyangyang
 * @date 2020/5/13
 */
public class TestMain {
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context =
//				new ClassPathXmlApplicationContext("applicationContext.xml");
//		Person person = (Person)context.getBean("person");
//		System.out.println(person);

		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = applicationContext.getBean(Person.class);
		System.out.println(person);

		String[] names = applicationContext.getBeanNamesForType(Person.class);
		for(String name:names){
			System.out.println(name);
		}
	}
}
