package com.ysy.test;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author shanyangyang
 * @date 2020/6/9
 */
public class IOCTestOfRresh {
	@Test
	public void test(){
//		ClassPathResource resource =new ClassPathResource("applicationContext.xml");
//		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//		reader.loadBeanDefinitions(resource);

		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
	}
}
