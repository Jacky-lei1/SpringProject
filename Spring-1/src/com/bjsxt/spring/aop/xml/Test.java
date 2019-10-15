package com.bjsxt.spring.aop.xml;

import com.bjsxt.spring.aop.impl.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lvyelanshan
 * @create 2019-10-15 17:06
 */
public class Test {
    public static void main(String[] args) {
        //1、创建Spring的IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bjsxt/spring/aop/applicationContext.xml");

        //2、从IOC容器中获取bean的实例
        Calculator calculator = (Calculator) ctx.getBean("calculatorImpl");

        //3、使用bean
        int result = calculator.add(3, 6);
        System.out.println("result:"+result);

         result = calculator.div(12, 2);
        System.out.println("result:"+result);



    }
}
