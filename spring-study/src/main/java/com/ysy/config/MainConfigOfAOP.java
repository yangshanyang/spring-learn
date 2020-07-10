package com.ysy.config;

import com.ysy.aop.LogAspect;
import com.ysy.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author shanyangyang
 * @date 2020/6/11
 * AOP[动态代理]
 * 		指能在程序运行期间动态的将某段代码切入到指定到指定方法指定位置的变成方式；
 * 1、导入AOP模块	：Spring AOP （spring-aspect）
 * 2、定义一个业务逻辑类，比如数学运算，在方法运行前、后，异常/返回的情况下打印
 * 3、定义一个日志切面类，切面类里面的方法，感知运算方法运行到哪里，然后执行
 * 		通知方法：
 * 				前置通知(@Before)
 * 				后置通知(@After):无论方法是正常结束，还是异常结束
 * 				返回通知(@AfterReturning)
 * 				异常通知(@AfterThrowing)
 * 				环绕通知：(@Around)动态代理，手动推进方法的执行（joinPoint.procced）
 *
 * 4、给切面类标注何时何地执行
 * 5、将业务代码和切面类都添加到容器中
 * 6、必须告诉spring哪个类是切面类(给切面类添加注解@Aspect)
 * 7、给配置类添加@EnableAspectJAutoProxy:开启基于注解的AOP模式
 *
 *
 * 主要的三步：
 *  1、将业务类和切面类都加入到容器中，并且告诉容器哪个是切面类
 *  2、在切面类中标注何时何地执行
 *  3、开启基于注解的AOP配置模式@EnableAspectJAutoProxy
 *
 *
 *  AOP原理：
 * 			@EnableAspectJAutoProxy
 * 		1、@EnableAspectJAutoProxy
 * 			@Import(AspectJAutoProxyRegistrar.class)：给容器中导入	AspectJAutoProxyRegistrar
 * 			利用	AspectJAutoProxyRegistrar自定义给容器中注册一些bean
 * 		internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 * 	给容器中注册一个	AnnotationAwareAspectJAutoProxyCreator
 * 	2、AnnotationAwareAspectJAutoProxyCreator
 * 	     ---AspectJAwareAdvisorAutoProxyCreator
 * 	        ---AbstractAdvisorAutoProxyCreator
 * 	           ---AbstractAutoProxyCreator
 * 	           				public abstract class AbstractAutoProxyCreator extends ProxyProcessorSupport
 * 									implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *
 * 			关注	SmartInstantiationAwareBeanPostProcessor 初始化前后的后置处理器  和BeanFactoryAware  可以注入beanfactory
 *
 * 	关键就看这个组件什么时候工作，这个组件的功能
 *
 * 	=========================以上是创建和注册AnnotationAwareAspectJAutoProxyCreator的过程=======================================================
 * 	AnnotationAwareAspectJAutoProxyCreator-----InstantiationAwareBeanPostProcessor
 * 	4)finishBeanFactoryInitialization(beanFactory);完成beanfacoty的初始化工作，创建剩下的单实例bean
 * 			1）遍历获取容器中所有的bean，依次创建对象getBean(name);
 * 			2)创建Bean
 * 					先去缓存中获取，如果能获取到，说明Bean之前被创建过；否则再创建；
 * 				只要创建好的bean都会被缓存起来
 * 			    createBean
 * 			    resolveBeforeInstantiation  后置处理器，在此处能返回一个代理对象；如果能返回代理对象，就使用，如果不能，就继续调用createBean（）
 * 			    applyBeanPostProcessorsBeforeInstantiation
 * 			    applyBeanPostProcessorsAfterInitialization
 * 			    docreateBean
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAOP {
	@Bean
	public MathCalculator mathCalculator(){
		return new MathCalculator();
	}
	@Bean
	public LogAspect logAspect(){
		return new LogAspect();
	}
}
