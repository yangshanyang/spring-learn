package com.ysy.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author shanyangyang
 * @date 2020/6/2
 */
@Component
public class Dog implements ApplicationContextAware {

	private ApplicationContext context;

	public Dog() {
		System.out.println("dog constuctor .....");
	}



	@Override public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
}
