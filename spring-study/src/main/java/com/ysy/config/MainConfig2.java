package com.ysy.config;

import com.ysy.bean.Color;
import com.ysy.bean.ColorFactoryBean;
import com.ysy.bean.Red;
import com.ysy.Person;
import com.ysy.condition.LinuxCondition;
import com.ysy.condition.MacCondition;
import com.ysy.condition.MyImportBeanDefinitionRegistrar;
import com.ysy.condition.MyImportSelector;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author shanyangyang
 * @date 2020/5/27
 */
@Configuration
//导入组件，id默认是全类名
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
	/**
	 * 默认是单例的
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * 单实例情况下，ioc容器启动会调用方法创建对象放到IOC容器中，以后每次调用从容器中(map.get)拿；
	 * request:同一个请求
	 * session：同一个session
	 *
	 * 懒加载：
	 * 		单实例bean，容器启动时，先不创建对象，第一次使用的时候再创建对象，并进行初始化
	*/
//	@Scope("prototype")
	@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("给容器添加bean");
		return new Person("zhangsan",21);
	}

/**@Conditional
 * 按照一定条件进行判断，满足条件注册Bean
 *如果是windows系统则注册ali，否则注册百度;
 * 可以放在类上，表示condition为true时，配置类中所有bean一起生效
*/

@Conditional({MacCondition.class})
@Bean("ali")
public Person person01(){
	return new Person("alibaba",12);
}

@Conditional({LinuxCondition.class})
	@Bean("baidui")
	public Person person02(){
		return new Person("baidu",24);
	}

/**
 * 给容器注册组件：
 * 1）包扫描+组件标注注解（@Controller,@Service,@Component,@Repository）[局限：自己写的]
 * 2）@Bean [导入的第三方包里面的组件]
 * 3）@Import[快速的给容器中导入组件]
 *    1)@Import(要导入到容器中的组件)，容器中就会自动注册这个组件，id默认是全类名
 *    2）@ImportSelecor：返回需要导入的组件的全类名的数组
 *    3)ImportBeanDefinitionRegistrar:手动注册bean到容器中
 *    4）Spring提供的FactoryBean(工厂Bean)
 *    		1)默认获取的是工厂Bean调用getObejct()创建的对象
 *    	    2）要想获取工厂类型的Bean，我们需要再beanId前面添加一个&符号
*/

@Bean
	public ColorFactoryBean colorFactoryBean(){
	return new ColorFactoryBean();
}
}
