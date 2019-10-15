package com.bjsxt.spring.aop.xml;

/**
 * @author lvyelanshan
 * @create 2019-10-15 17:12
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;


public class LoggingAspect {


    public void declareJoinPointExpression(){}


    public void beforeMethod(JoinPoint joinPoint){
        //获取当前方法名
        String methodName = joinPoint.getSignature().getName();
        //获取当前方法中传递的参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method begins "+methodName+" begins with"+args);
    }


    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends");
    }



    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName +" ends with " + result);
    }


    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName +" occurs excetion: " + ex);
    }

    public Object aroundMethod(ProceedingJoinPoint pjd){

       Object result = null;
       String methodName = pjd.getSignature().getName();//获得当前执行的方法名

        //执行目标方法
        try {
            //前置通知
            System.out.println("The method "+methodName +" begins with" + Arrays.asList(pjd.getArgs()));
            result = pjd.proceed();//执行目标方法
            //返回通知
            System.out.println("The method ends with "+ result);
        } catch (Throwable throwable) {
            //异常通知
            //出现异常打印一下信息，然后将异常抛出去，避免result返回为空
            System.out.println("The method "+methodName+" occurs exception:"+throwable);
            throw new RuntimeException();
        }
        //后置通知(因为可能会抛出异常，所有无法得到返回值)
        System.out.println("The method "+methodName+" ends");
        return result;
    }


}
