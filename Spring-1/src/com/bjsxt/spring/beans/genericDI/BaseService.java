package com.bjsxt.spring.beans.genericDI;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lvyelanshan
 * @create 2019-10-15 14:28
 */
public class BaseService<T> {

    /**
     * 实际上注入的是子类的对象，而且其中的泛型T注入的也是子类对应的类型
     * 相当于BaseRepository<User> repository = new UserRepository<User>
     */
    @Autowired
    protected BaseRepository<T> repository;

    public void add(){
        System.out.println("add...");
        System.out.println(repository);
    }
}
