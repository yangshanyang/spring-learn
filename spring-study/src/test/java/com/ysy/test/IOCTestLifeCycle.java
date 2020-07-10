package com.ysy.test;

import com.ysy.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shanyangyang
 * @date 2020/5/31
 */
public class IOCTestLifeCycle {

	@Test
	public void test01(){
		//创建IOC容器
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成。。。。");
		context.getBean("car");
		context.close();
	}
}
