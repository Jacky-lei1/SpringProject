package com.bjsxt.spring.beans.beans;

/**
 * @author lvyelanshan
 * @create 2019-10-14 17:18
 */
public class Car {

    private String brand;
    private double price;
    //轮胎的周长
    private double typePerimeter;

    public Car(String brand, double price, double typePerimeter) {
        this.brand = brand;
        this.price = price;
        this.typePerimeter = typePerimeter;
    }

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTypePerimeter() {
        return typePerimeter;
    }

    public void setTypePerimeter(double typePerimeter) {
        this.typePerimeter = typePerimeter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", typePerimeter=" + typePerimeter +
                '}';
    }
}
