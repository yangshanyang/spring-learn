package com.ysy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author shanyangyang
 * @date 2020/6/11
 * 切面类
 */
@Aspect
public class LogAspect {
	//抽取公共的切入点表达式
	//1、本类引用
	//2、其他的切面引用
	@Pointcut("execution(public int com.ysy.aop.MathCalculator.*(..))")
	public void pointCut(){}

	//切入点表达式，指定在哪个方法切入
	//JoinPoint必须出现在参数的第一位
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println(""+joinPoint.getSignature().getName()+"除法运行。。。参数列表是：{"+ Arrays.asList(args)+"}");
	}

	@After("pointCut()")
	public void logEnd(){
		System.out.println("除法结束。。。。。。");
	}

	@AfterReturning(value = "pointCut()",returning = "result")
	public void logReturn(Object result){
		System.out.println("除法正常返回。。。运行个结果：{}"+result);
	}

	@AfterThrowing(value = "pointCut()",throwing = "exception")
	public void logException(Exception exception){
		System.out.println("除法出现异常。。。。。异常信息是：{}"+exception);
	}
}
