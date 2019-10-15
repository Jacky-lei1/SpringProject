package com.bjsxt.spring.beans.beans;

/**
 * @author lvyelanshan
 * @create 2019-10-14 17:21
 */
public class Person {

    private String name;

//    private Address address;

    private Car car;

    //city引用address bean的city属性
    private String city;

    //根据car的price确定info:car的price >= 300000:金领 ，否则为白领
    private String info;


    public Person(String name, Car car, String city, String info) {
        this.name = name;
        this.car = car;
        this.city = city;
        this.info = info;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
