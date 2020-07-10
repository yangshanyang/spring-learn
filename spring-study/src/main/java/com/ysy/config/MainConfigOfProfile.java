package com.ysy.config;

import com.ysy.bean.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author shanyangyang
 * @date 2020/6/8
 *  * Profile:指定组件在哪个环境的情况下从能被注册到容器中；不指定，任何环境下都能注册到容器中
 *  * 		spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *  * 	开发环境、测试环境和生产环境
 *  * 	数据源：A、B、C
 *
 *  写在配置类上，只有是指定的环境，整个配置类中的Bean才会注入;否则包括配置类在内都不会注册；
 *
 *  没有标注@Profile注解的类，在任何环境下都会加载
 */
@Profile("testB")
@Configuration
public class MainConfigOfProfile {

	@Profile("testA")
	@Bean
	public DataSource dataSourceA(){
		DataSource dataSource = new DataSource();
		dataSource.setUser("A");
		dataSource.setPasswd("1");
		return dataSource;
	}

	@Profile("devB")
	@Bean
	public DataSource dataSourceB(){
		DataSource dataSource = new DataSource();
		dataSource.setUser("A");
		dataSource.setPasswd("1");
		return dataSource;
	}

	@Profile("proC")
	@Bean
	public DataSource dataSourceC(){
		DataSource dataSource = new DataSource();
		dataSource.setUser("A");
		dataSource.setPasswd("1");
		return dataSource;
	}
}
