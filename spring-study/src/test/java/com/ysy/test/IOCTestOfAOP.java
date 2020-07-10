package com.ysy.test;

import com.ysy.aop.MathCalculator;
import com.ysy.bean.Boss;
import com.ysy.bean.Car;
import com.ysy.config.MainConfigOfAOP;
import com.ysy.config.MainConfigOfAutowired;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shanyangyang
 * @date 2020/6/4
 */
public class IOCTestOfAOP {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		MathCalculator mathCalculator = context.getBean(MathCalculator.class);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for(String name : beanDefinitionNames){
			System.out.println(name);
		}
		mathCalculator.div(1,1);

		String[] beanDefinitionNames1 = context.getBeanDefinitionNames();
		for(String name : beanDefinitionNames1){
			System.out.println("==="+name);
		}
		context.close();
	}
}
