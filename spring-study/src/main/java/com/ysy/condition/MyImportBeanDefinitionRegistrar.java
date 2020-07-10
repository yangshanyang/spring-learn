package com.ysy.condition;

import com.ysy.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author shanyangyang
 * @date 2020/5/29
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	/**
	 *AnnotationMetadata:当前类的注解信息
	 * BeanDefinitionRegistry：BeanDefinition注册类
	 * 		把所有需要添加到容器中的bean，调用BeanDefinitionRegistry.registerBeanDefinition手工注册
	 * */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry,
			BeanNameGenerator importBeanNameGenerator) {

		boolean definition = registry.containsBeanDefinition("com.ysy.Bean.Red");
		boolean definition1 = registry.containsBeanDefinition("com.ysy.Bean.Blue");
		if(definition && definition1){
			//指定Bean定义信息，(bean的类型等等)
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			//注册一个Bean，指定Bean名字
			registry.registerBeanDefinition("rainBowl",rootBeanDefinition);
		}
	}
}
