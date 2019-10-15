package com.bjsxt.spring.beans.factorybean;

import com.bjsxt.spring.beans.beans.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lvyelanshan
 * @create 2019-10-15 9:23
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bjsxt/spring/beans/beans/beans-beanfactory.xml");
        Car car = (Car) ctx.getBean("car");
        System.out.println(car);
    }
}
