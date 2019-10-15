package com.bjsxt.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 配置另外一个切面，测试切面的优先级
 * @author lvyelanshan
 * @create 2019-10-15 21:18
 */
//可以使用@Order注解指定切面的优先级，值越小，优先级越高
@Order(1)
@Component
@Aspect
public class LoggingAspect2 {

    @Before("execution(public int com.bjsxt.spring.aop.impl.Calculator.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String methName = joinPoint.getSignature().getName();//获得方法的名字
        Object[] args = joinPoint.getArgs();//获得方法的参数
        System.out.println("---->The method "+methName+" begin with "+ Arrays.asList(args));

    }

}
