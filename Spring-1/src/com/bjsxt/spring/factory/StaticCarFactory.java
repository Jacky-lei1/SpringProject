package com.bjsxt.spring.factory;

/**
 * @author lvyelanshan
 * @create 2019-10-14 19:33
 */

import com.bjsxt.spring.beans.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法：直接调用某个类的静态方法就可以返回bean的实例
 */
public class StaticCarFactory {
    
    private static Map<String, Car> cars = new HashMap<String, Car>();
    
    static { //静态初始化块，在类加载
        cars.put("audi",new Car("audi",300000));
        cars.put("ford",new Car("ford",400000));
    }
    
    //静态工厂方法，模拟静态工厂方法创建对象的思路
    //通过静态方法返回bean，而不需要new一个该类的新的对象
    public static Car getCar(String name){
        Car car = cars.get(name);
        return car; //通过这个类中的方法就可以返回一个Car对象。
    }
}
