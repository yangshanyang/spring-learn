package com.ysy.config;

import com.ysy.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author shanyangyang
 * @date 2020/5/31
 * Bean生命周期：
 * 		Bean创建—————初始化——————销毁的过程
 * 容器管理Bean的生命周期：
 * 	我们可以自定义初始化和销毁方法，容器在进行到对应的步骤时，会调用我们自定义的方法
 * 	1）指定初始化和销毁方法
 * 		通过@Bean指定init-method="getTestStr" destroy-method="getTestStr"
 *
 * 	2）通过让bean实现InitializingBean接口和DisposableBean接口
 *
 * 	3)通过使用JSR250
 * 		1）@PostConstruct:在Bean创建完成并且属性赋值完成，来执行初始化方法；
 * 		2）@PreDestroy:在容器销毁Bean之前通知进行清理工作；
 *
 * 	4)BeanPostProcessor:bean的后置处理器
 * 		在Bean的初始化前后进行一些处理工作
 * 		postProcessBeforeInitialization：在初始化调用之前
 * 			Apply this {@code BeanPostProcessor} to the given new bean instance <i>before</i> any bean
 * 	 		initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
 * 	 		 or a custom init-method).
 * 		postProcessAfterInitialization：在初始化之后
 * 			Apply this {@code BeanPostProcessor} to the given new bean instance <i>after</i> any bean
 * 	 * 		initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
 * 	 * 		or a custom init-method).
 *
 *构造(对象实例)
 * 	1）单实例：在容器启动的时候创建对象
 * 	2）多实例：在每次获取的时候创建对象
 *
 * BeanPostProcessor.postProcessBeforeInitialization
 *初始化：
 * 		对象创建完成，并赋值完成，调用初始化方法。。。。
 *
 * BeanPostProcessor.postProcessAfterInitialization
 * 销毁：
 * 		单实例：容器关闭的时候
 * 		多实例：容器不会管理这个Bean，容器不会调用销毁方法
 *
 * populateBean之后执行下面的方法：
 * 给Bean属性赋值
 *
 *遍历得到容器所有的BeanPostProcessor，挨个执行BeforeInitialization，一旦返回null，跳出for循环，不会执行后面的BeanPostProcessor
 * 		if (mbd == null || !mbd.isSynthetic()) {
 * 			wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *                }
 *
 * 		try {
 * 			//执行初始化方法
 * 			invokeInitMethods(beanName, wrappedBean, mbd);
 *        }
 * 		catch (Throwable ex) {
 * 			throw new BeanCreationException(
 * 					(mbd != null ? mbd.getResourceDescription() : null),
 * 					beanName, "Invocation of init method failed", ex);
 *        }
 * 		if (mbd == null || !mbd.isSynthetic()) {
 * 			wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *        }
 *
 *
 *        Spring底层对BeanPostProcessor的使用，
 *        	bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Sync,等等；
 *
 */
@Configuration
@ComponentScan("com.ysy.bean")
public class MainConfigOfLifeCycle {

	//@Scope("prototype")
	@Bean(initMethod = "init",destroyMethod = "destroy")
	public Car car(){
		return new Car();
	}
}
