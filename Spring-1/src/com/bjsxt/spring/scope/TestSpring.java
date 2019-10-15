package com.bjsxt.spring.scope;

import com.bjsxt.spring.beans.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lvyelanshan
 * @create 2019-10-14 16:38
 */
public class TestSpring {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");

        Address address = (Address) ctx.getBean("address");
        System.out.println(address);

        address = (Address) ctx.getBean("address2");
        System.out.println(address);
    }

}
