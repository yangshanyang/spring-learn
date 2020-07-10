package com.ysy.config;

import com.ysy.Dao.BookDao;
import com.ysy.bean.Car;
import com.ysy.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author shanyangyang
 * @date 2020/6/4
 * 自动装配：
 *		spring利用依赖注入，完成对IOC容器中各个组件的依赖赋值
 * （1）@Autowired：自动注入 默认优先按照类型去容器中查找组件，找到就赋值；
 * （2）如果找到多个，再按照ID去组件中进行匹配
 * （3）@Qualifier("bookDao") 限定ID来匹配组件ID，而不是按照类型
 * （4）可以使用@Autowired(required=false) 来使引入的组件为null
 *
 *（5） @Primary：让spring进行自动装配的时候默认使用首选bean;当同时有@Qualifier注解时，以@Qualifier注解为准
 *
 * 2、java规范注解
 * @Resouce:实现自动装配功能，默认按照组件名称进行装配；没有能支持@Primary；
 *
 * @Inject：和Autowired一样，没有required=false 这个功能
 *
 *3、@Autowired:构造函数、参数和方法，都是从容器中获取组件的值
 *    1、标注在方法位置上，@Bean+方法参数，参数从容器中获取；默认不写@Autowired效果是一样的，都能自动注入
 *    2、标注在构造器上，如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略；
 *    3、放在参数位置，
 *
 * 4、自定义组件想要使用spring容器底层一些组件(ApplicationContext、BeanFactory),自定义组件只需要实现XXXAware接口即可；
 *
 *
 *
 */
@Configuration
@ComponentScan({"com.ysy.controller","com.ysy.service","com.ysy.Dao","com.ysy.bean"})
public class MainConfigOfAutowired {

	@Primary
	@Bean("bookDao2")
	public BookDao bookDao(){
		BookDao bookDao = new BookDao();
		bookDao.setLabel("2");
		return bookDao;
	}
}
