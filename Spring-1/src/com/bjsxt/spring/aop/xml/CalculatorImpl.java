package com.bjsxt.spring.aop.xml;


/**
 * @author lvyelanshan
 * @create 2019-10-15 15:16
 */

public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i+j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i-j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i*j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i/j;
        return result;
    }
}
