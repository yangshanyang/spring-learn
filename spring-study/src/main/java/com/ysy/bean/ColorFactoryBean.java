package com.ysy.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author shanyangyang
 * @date 2020/5/30
 * 创建一个Spring定义的工厂Bean
 */

public class ColorFactoryBean implements FactoryBean<Color> {
	/**
	 *返回一个Color对象，这个对象会添加到容器中
	 */

	@Override
	public Color getObject() throws Exception {
		return new Color();
	}

	@Override public Class<?> getObjectType() {
		return Color.class;
	}

	@Override public boolean isSingleton() {
		return false;
	}
}
