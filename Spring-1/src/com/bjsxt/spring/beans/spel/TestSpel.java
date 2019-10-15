package com.bjsxt.spring.beans.spel;

import com.bjsxt.spring.beans.beans.Address;
import com.bjsxt.spring.beans.beans.Car;
import com.bjsxt.spring.beans.beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lvyelanshan
 * @create 2019-10-14 17:32
 */
public class TestSpel {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bjsxt/spring/beans/beans/beans-spel.xml");

        Address address = (Address) ctx.getBean("address");
        System.out.println(address);

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

}
