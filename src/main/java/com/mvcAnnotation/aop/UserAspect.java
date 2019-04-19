package com.mvcAnnotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.mvcAnnotation.pojo.User;

@Component
@Aspect
public class UserAspect {
	//用户登录切入记录日志
	@Pointcut("execution(* com.mvcAnnotation.service.impl.UserServiceImpl.login(..))")
	private void userLogin(){}//添加用户 
	
	@AfterReturning(pointcut="userLogin()",returning="rtv")
	public void loginAdvice(JoinPoint joinPoint,User rtv) {
		if(rtv!=null) {
			System.out.println(rtv);
		}
	}
}
