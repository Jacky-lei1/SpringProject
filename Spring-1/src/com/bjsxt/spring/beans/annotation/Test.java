package com.bjsxt.spring.beans.annotation;

import com.bjsxt.spring.beans.annotation.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lvyelanshan
 * @create 2019-10-15 9:52
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/bjsxt/spring/beans/beans/beans-annotation.xml");

//        /*通过扫描@Component注解获取到的对象，bean默认的id名称是首字母小写的类名*/
//        TestObject testObject = (TestObject) ctx.getBean("testObject");
//        System.out.println(testObject);

        /*通过扫描@Controller注解获取到的对象，bean默认的id名是首字母小写的类名*/
        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();
//
//        UserService userService = (UserService) ctx.getBean("userService");
//        System.out.println(userService);
//
//        UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
//        System.out.println(userRepository);



    }
}
