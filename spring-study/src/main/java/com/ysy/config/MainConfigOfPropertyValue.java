package com.ysy.config;

import com.ysy.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author shanyangyang
 * @date 2020/6/2
 */
//使用PropertySource读取外部文件中的k/v保存到运行的环境变量中
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValue {
	@Bean
	public Person person(){
		return new Person();
	}

}
