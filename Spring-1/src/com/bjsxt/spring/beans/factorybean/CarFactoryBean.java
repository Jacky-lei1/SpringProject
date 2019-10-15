package com.bjsxt.spring.beans.factorybean;

import com.bjsxt.spring.beans.beans.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lvyelanshan
 * @create 2019-10-15 9:17
 */

//自定义的FactoryBean需要实现FactoryBean接口
public class CarFactoryBean implements FactoryBean<Car> {


    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     返回bean的对象
     *
     */
    @Override
    public Car getObject() throws Exception {
        return new Car(brand,500000);
    }

    /**
     * 返回bean的类型
     * @return
     */

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
