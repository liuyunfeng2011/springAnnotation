package com.mvcAnnotation.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.mvcAnnotation.pojo.User;

@Component
@Aspect
public class ExAspect {
	Logger logger=Logger.getLogger(ExAspect.class);
	 String logMsg=null;
	//用户登录切入记录日志
	@Pointcut("execution(* com.mvcAnnotation.service.impl.*.*(..))")
	private void exPointcut(){}//异常记录
	
	@Before("exPointcut()")
	public void doBefore(JoinPoint jp){
		logMsg=jp.getTarget().getClass().getName()+"类的"
                +jp.getSignature().getName()+"方法开始执行******Start******";
        logger.info(logger);
    }
	
	/**
	 * 思考：当这里处理了异常之后上抛的异常还会被被controller抓到？
	 * @param pjp
	 * @return
	 */
//	@Around("exPointcut()")
//	 public Object doAround(ProceedingJoinPoint pjp){
//	        long Time=System.currentTimeMillis();
//	        Object result=null;
//	        try {
//	            result=pjp.proceed();
//	        } catch (Throwable e) {
//	            e.printStackTrace();
//	            logMsg="方法："+pjp.getTarget().getClass()+"."+pjp.getSignature().getName()+"()";
//	            logMsg=logMsg+"错误信息如下：["+e+"]";
//	            logger.info(logMsg);
//	        }
//	        return result;
//	    }
	 
	 
	 
	 
	@After("exPointcut()")
	public void doAfter(JoinPoint jp){
		logMsg=jp.getTarget().getClass().getName()+"类的"
	                +jp.getSignature().getName()+"方法执行结束******End******";
	        logger.info(logMsg);
    }
	
	
	
	/**
	 * 被上边的doAround盖住了，异常全部处理完毕了
	 * 思考:被盖住的异常，controller不需要再处理异常，用户页面只会不显示数据，不会有报错页面出现了
	 * @param ex
	 */
	@AfterThrowing(pointcut="exPointcut()",throwing="ex")
	public void exAdvice(Throwable ex) {
		System.out.println(ex);
		System.out.println("出现异常了大哥");
	}
	
}
