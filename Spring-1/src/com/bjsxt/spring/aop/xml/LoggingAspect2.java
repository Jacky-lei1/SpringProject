package com.bjsxt.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class LoggingAspect2 {

    public void beforeMethod(JoinPoint joinPoint){
        String methName = joinPoint.getSignature().getName();//获得方法的名字
        Object[] args = joinPoint.getArgs();//获得方法的参数
        System.out.println("---->The method "+methName+" begin with "+ Arrays.asList(args));

    }

}
