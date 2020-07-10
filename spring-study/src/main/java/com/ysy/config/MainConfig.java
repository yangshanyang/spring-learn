package com.ysy.config;

import com.ysy.Person;
import com.ysy.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author shanyangyang
 * @date 2020/5/22
 * 配置类等于以前的配置文件
 */
@Configuration  //告诉spring这是一个配置类
@ComponentScan(value = "com.ysy",includeFilters = @ComponentScan.Filter(
		type = FilterType.CUSTOM,classes = MyTypeFilter.class
//		type=FilterType.ASSIGNABLE_TYPE,classes = BookService.class
//		type = FilterType.ANNOTATION,classes = Controller.class
		),useDefaultFilters = false)
//value指定要扫描的包
//Filter[] excludeFilters() default {}; 扫描的时候按照规则排除哪些
//@ComponentScan(value = "com.ysy",excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class,
//		Service.class}))
//includeFilters 扫描的时候按照规则只包含哪些
//ASSIGNABLE_TYPE按照指定类型进行扫描
//使用aspectJ表达式
//REGEX：正则表达式
//custom：自定义规则
public class MainConfig {
	@Bean("person") //给容器中注册一个bean，为返回值的类型，id默认是方法名
	public Person person01(){
		return new Person("lisi",20);
	}
}
