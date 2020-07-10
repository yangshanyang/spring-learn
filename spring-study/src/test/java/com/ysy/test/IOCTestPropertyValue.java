package com.ysy.test;

import com.ysy.Person;
import com.ysy.config.MainConfigOfLifeCycle;
import com.ysy.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author shanyangyang
 * @date 2020/5/31
 */
public class IOCTestPropertyValue {

	@Test
	public void test01(){
		//创建IOC容器
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
		System.out.println("容器创建完成。。。。");
		print(context);
		ConfigurableEnvironment environment = context.getEnvironment();
		String property = environment.getProperty("person.nickName");
		System.out.println(property);
		Person person = (Person)context.getBean("person");
		System.out.println(person);
		context.close();
	}

	private void print(AnnotationConfigApplicationContext context) {
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name:beanDefinitionNames){
			System.out.println(name);
		}
	}
}
