package com.ysy.test;

import com.ysy.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shanyangyang
 * @date 2020/6/8

 */
public class IOCTestOfProfile {
	//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

	//1、使用命令行动态参数，在虚拟机参数位置加载：-Dspring.profiles.active=test
	//2、创建一个AnnotationConfigApplicationContext对象，无参构造器;设置需要激活的环境；注册配置类，启动刷新容器
	@Test
	public void test01(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("testA");
		context.register(MainConfigOfProfile.class);
		context.refresh();
		print(context);
	}

	private void print(AnnotationConfigApplicationContext context) {
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name:beanDefinitionNames){
			System.out.println(name);
		}
	}
}
