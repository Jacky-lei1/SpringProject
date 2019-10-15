package com.bjsxt.spring.beans.genericDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lvyelanshan
 * @create 2019-10-15 14:35
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bjsxt/spring/beans/base-generic-di.xml");

        UserService userService = (UserService) ctx.getBean("userService");
        userService.add();
    }
}
