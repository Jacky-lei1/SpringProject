package com.bjsxt.spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * @author lvyelanshan
 * @create 2019-10-15 11:40
 */
@Repository
public class UserRepositoryJdbc implements UserRepository{
    @Override
    public void save() {
        System.out.println("UserRepositoryJdbc的save方法。。。");
    }
}
