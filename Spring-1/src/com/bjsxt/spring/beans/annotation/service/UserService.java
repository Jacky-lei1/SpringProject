package com.bjsxt.spring.beans.annotation.service;

import com.bjsxt.spring.beans.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author lvyelanshan
 * @create 2019-10-15 9:46
 */
@Service
public class UserService {


//    @Autowired //加上这个注解后会去IOC容器中找，看有没有和这个类型相同的bean，直接装配。
    private UserRepository userRepository;

    //将扫描到的同类型的bean对象自动装配到参数中
    @Autowired
    /**
     * 如果一个接口中存在两个实现类，则可以通过@Qualifier("userRepositoryImpl")
     * 重新定义要注入的实现类
     * 这里的注解也可以加入到方法的参数前面
     */
    @Qualifier("userRepositoryImpl")
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void add(){
        System.out.println("UserService的add方法。。。");
        userRepository.save();
    }
}
