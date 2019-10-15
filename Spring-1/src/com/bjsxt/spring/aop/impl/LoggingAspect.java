package com.bjsxt.spring.aop.impl;

/**
 * @author lvyelanshan
 * @create 2019-10-15 17:12
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 把该类声明为一个切面：
 * 1、需要把该类放到IOC容器中
 * 2、再声明一个切面
 *
 */
//可以使用@Order注解指定切面的优先级，值越小，优先级越高
@Order(2)
@Component
//声明切面
@Aspect
public class LoggingAspect {
    /**
     * 当我们调用目标方法，而这个目标方法跟声明的注解相匹配的时候
     * 那么SpringIOC容器会自动的为那个方法生成代理对象
     * 在目标方法执行之前或者之后执行相应的语句
     */
    /**
     * 定义一个方法，用于声明切入点表达式，一般地，该方法中不需要添加其他的代码
     * 使用@Pointcut来声明切入点表达式
     * 后面的其他通知直接使用方法来引用当前的切入点表达式
     */
    @Pointcut("execution(public int com.bjsxt.spring.aop.impl.Calculator.*(..))")
    public void declareJoinPointExpression(){}

    //声明该方法是一个前置通知：在目标方法开始之前执行，*表示对这个接口中所有的方法都声明通知
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        //获取当前方法名
        String methodName = joinPoint.getSignature().getName();
        //获取当前方法中传递的参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method begins "+methodName+" begins with"+args);
    }

    //后置通知：在目标方法执行后（无论是否发生异常），执行的通知
    //在后置通知中还不能访问目标方法执行的结果。
    @After("declareJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends");
    }


    /**
     * 返回通知：在方法正常执行结束后的通知
     * 返回通知是可以访问到方法的返回值的
     */
    @AfterReturning(value = "declareJoinPointExpression()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName +" ends with " + result);
    }

    /**
     * 异常通知：在方法出现异常时会执行的方法，可以访问到异常信息
     * 且可以指定在出现特定异常时在执行通知代码
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "declareJoinPointExpression()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName +" occurs excetion: " + ex);
    }

    /**
     * 环绕通知需要携带ProceedingJoinPoint类型的参数
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法，
     * 且环绕通知必须有返回值
     */
    @Around(value = "declareJoinPointExpression()")
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
