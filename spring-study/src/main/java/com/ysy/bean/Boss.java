package com.ysy.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shanyangyang
 * @date 2020/6/4
 */
@Component
public class Boss {

	private Car car;

	public Car getCar() {
		return car;
	}

	@Autowired  //构造器中的car也是从容器中获取的
	public Boss(Car car) {
		this.car = car;
	}

	//@Autowired  //标注在方法时，Spring容器创建当前对象，就会调用方法，完成赋值；方法使用参数：自定义类型的值从IOC容器中获取
	public void setCar(Car car) {
		this.car = car;
	}

	@Override public String toString() {
		return "Boss{" + "car=" + car + '}';
	}
}
