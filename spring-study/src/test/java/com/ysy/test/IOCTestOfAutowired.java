package com.ysy.test;

import com.ysy.Dao.BookDao;
import com.ysy.bean.Boss;
import com.ysy.bean.Car;
import com.ysy.config.MainConfigOfAutowired;
import com.ysy.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shanyangyang
 * @date 2020/6/4
 */
public class IOCTestOfAutowired {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
		//BookService bean = context.getBean(BookService.class);
		//bean.print();
		//System.out.println(context.getBean(BookDao.class));

		Boss boss = context.getBean(Boss.class);
		System.out.println(boss);
		System.out.println(context.getBean(Car.class));
		context.close();
	}
}
