package com.ysy.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author shanyangyang
 * @date 2020/5/28
 * 判断是否是mac系统
 * ConditionContext:判断条件能使用的上下文环境
 * AnnotatedTypeMetadata：注释信息
 */
public class MacCondition implements Condition {
	@Override public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//能获取IOC使用的beanfactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//获取当前环境信息
		Environment environment = context.getEnvironment();
		//获取Bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();

		//可以判断容器中的bean注册情况，也可以给容器中注册bean
		boolean definition = registry.containsBeanDefinition("person");


		return environment.getProperty("os.name").contains("Mac");

	}
}
