package com.ysy.test;

import com.ysy.Person;
import com.ysy.config.MainConfig;
import com.ysy.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author shanyangyang
 * @date 2020/5/22
 */
public class IOCTest {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

	@Test
	public void testImport(){
		printBeans(context);
	}

	public void printBeans(AnnotationConfigApplicationContext context){
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for(String name:beanDefinitionNames){
			System.out.println(name);
		}

		//工厂Bean获取的是调用getObject创建的对象
		Object colorFactoryBean = context.getBean("colorFactoryBean");
		System.out.println("Bean的类型==="+colorFactoryBean.getClass());

		Object colorFactoryBean1 = context.getBean("&colorFactoryBean");
		System.out.println("Bean的类型==="+colorFactoryBean1.getClass());
	}

//	@Test
//	public void test03(){
//		//获取环境变量和操作系统
//		ConfigurableEnvironment environment = context.getEnvironment();
//		//System.out.println(environment.getProperty("os.name"));
//		String[] beanNamesForTypes = context.getBeanNamesForType(Person.class);
//		for (String beanNameType:beanNamesForTypes){
//			System.out.println(beanNameType);
//		}
//
//		Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
//		System.out.println(beansOfType);
//	}

//	@Test
//	public void test01(){
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//
//		String[] definitionNames = context.getBeanDefinitionNames();
//		for(String name:definitionNames){
//			System.out.println(name);
//		}
//	}

//	@Test
//	public void test02(){
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
//
////		String[] definitionNames = context.getBeanDefinitionNames();
////		for(String name:definitionNames){
////			System.out.println(name);
////		}
//		System.out.println("容器初始化完成");
//		Object person = context.getBean("person");
//		Object person1 = context.getBean("person");
//		System.out.println(person == person1);
//	}
}
