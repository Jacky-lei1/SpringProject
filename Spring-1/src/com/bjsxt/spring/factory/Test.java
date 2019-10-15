package com.bjsxt.spring.factory;

        import com.bjsxt.spring.beans.Car;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lvyelanshan
 * @create 2019-10-14 20:35
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factory.xml");

        Car car1 = (Car) ctx.getBean("car1");

        System.out.println(car1);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);
    }

}
