package com.bjsxt.spring.aop.helloworld;

/**
 * @author lvyelanshan
 * @create 2019-10-15 15:20
 */
public class Test {
    public static void main(String[] args) {
//        Calculator calculator = null;
//        calculator = new CalculatorImpl();

        Calculator target = new CalculatorImpl();
        Calculator proxy = new CalculatorProxy(target).getLoggingProxy();

        int add = proxy.add(1, 2);
        System.out.println("-->"+add);

        int div = proxy.div(4, 2);
        System.out.println("-->"+div);
    }
}
