package com.ysy.bean;

import org.springframework.stereotype.Component;

/**
 * @author shanyangyang
 * @date 2020/5/31
 */
@Component
public class Car {
	public Car() {
		System.out.println("Car constructor....");
	}

/**
 * 一般用于数据源配置，赋值
 * */
	public void init(){
		System.out.println("Car init ...");
	}

	/**
	 * 数据源关闭
	 * */
	public void destroy(){
		System.out.println("Car destroy...");
	}
}
