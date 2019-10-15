package com.bjsxt.spring.beans.annotation.repository;

import com.bjsxt.spring.beans.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author lvyelanshan
 * @create 2019-10-15 9:45
 */
//指定id名@Repository("userRepository")
@Repository
public class UserRepositoryImpl implements UserRepository {

    //表示允许属性不被设置，
    // 当IOC容器中没有配置相应的bean时，不报错，但返回一个空
    @Autowired(required = false)
    private TestObject testObject;


    @Override
    public void save() {
        System.out.println("UserRepository的save方法");
        System.out.println(testObject);
    }
}
