package com.ysy.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author shanyangyang
 * @date 2020/5/29
 */
@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
	private ApplicationContext context;

	@Override public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("传入的IOC：：："+applicationContext);
		this.context = applicationContext;
	}

	@Override public void setBeanName(String name) {
		System.out.println("当前Bean的名字"+name);
	}

	@Override public void setEmbeddedValueResolver(StringValueResolver resolver) {
		System.out.println(resolver);
		String s = resolver.resolveStringValue("你好${os.name}");
		System.out.println("s==="+s);
	}
}
