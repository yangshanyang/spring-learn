package com.ysy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * @author shanyangyang
 * @date 2020/5/22
 */
public class Person {
	//使用@value赋值
	//1、基本数值
	//2、可以写SPEL表达式 #{}
	//3、可以写${},取出配置文件中的值（运行的环境变量中的值）
	@Value("ysy")
	private String name;
	@Value("#{10+18}")
	private Integer age;
	@Value("${person.nickName}")
	private String nickName;

	public Person() {
	}

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + ", nickName='" + nickName + '\'' + '}';
	}
}
