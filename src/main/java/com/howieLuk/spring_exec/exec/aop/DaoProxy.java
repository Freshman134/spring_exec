package com.howieLuk.spring_exec.exec.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoProxy {
	
	@Pointcut("execution(* com.howieLuk.spring_exec.exec.dao.*.*(..))")  //通过注解创建切面表达式签名
	public void pointCut() {}
	
	@Before("pointCut()")  //调用被Pointcut注解的方法，可以使用它的切面表达式
	public void before(JoinPoint joinPoint) {
		joinPoint.getArgs(); //获取被切方法参数
		Signature signature = joinPoint.getSignature(); //获取被切方法签名
		signature.getName();  //获取方法名
		System.out.println("beFore方法，打印 " + signature.getName());
	}
	
	@AfterReturning(value = "pointCut()", returning = "result"/*哪个参数作为返回值*/)
	public void afterReturing(Object result) {
		System.out.println("returning: " + result);
	}
	
	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void afterThrowing(Exception exception) {
		System.out.println("throwing: " + exception);
	}
	
	@After("pointCut()")
	public void after(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("after方法，打印 " + signature.getName());
	}
	
	/*
	 * 环绕整个方法的执行过程，这里可以决定目标方法是否执行，其他切面都不可以做到这一点
	 */
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint/*必要参数*/) {
		Object result = null;
		Object[] args = proceedingJoinPoint.getArgs();  //获取参数
		System.out.println("环绕开始");
		try {
			result = proceedingJoinPoint.proceed(args); //调用方法执行 before -> after
		} catch (Throwable e) {
			//异常时这里会执行。。。
		}  
		System.out.println("环绕结束");
		return result;
	}
	
}
