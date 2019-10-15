package com.bjsxt.spring.beans.annotation.controller;

import com.bjsxt.spring.beans.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lvyelanshan
 * @create 2019-10-15 9:47
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void execute(){
        System.out.println("UserController的方法。。。");
        userService.add();
    }
}
