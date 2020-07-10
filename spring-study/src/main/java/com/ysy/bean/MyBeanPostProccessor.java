package com.ysy.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器：初始化前后进行处理
 * bean the new bean instance
 * beanName the name of the bean
 * @author shanyangyang
 * @date 2020/5/31
 */
@Component
public class MyBeanPostProccessor implements BeanPostProcessor {
	@Override public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization......."+beanName+".....>>"+bean);
		return bean;
	}

	@Override public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization......."+beanName+".....>>"+bean);
		return bean;
	}
}
