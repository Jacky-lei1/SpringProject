package com.bjsxt.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author lvyelanshan
 * @create 2019-10-15 15:32
 */
public class CalculatorProxy {
    //要代理的对象
    private Calculator target;

    public CalculatorProxy(Calculator target) {
        this.target = target;
    }

    //返回要代理的对象
    public Calculator getLoggingProxy(){
        Calculator proxy = null;
        /**
         * 创建代理对象
         */
        //创建代理对象的类加载器（代理对象由哪一个类加载器加载）
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class [] interfaces = new Class[]{Calculator.class};

        //当调用代理对象的方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            /**
             *
             * @param proxy:正在返回的那个代理对象，一般情况下，在invoke方法中都不使用该对象
             * @param method:正在被调用的方法
             * @param args:调用方法时传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methdoName = method.getName();
                /*Arrays.asList(args):表示将一个数组装换成list集合*/
                try {
                    //日志(相当于前置通知)
                    System.out.println("The method "+ methdoName+"begins with"+ Arrays.asList(args));
                    //执行方法
                    Object result = method.invoke(target, args);
                    //返回通知，可以得到方法的返回值
                }catch (Exception e){
                    e.printStackTrace();
                    //异常通知，可以访问到方法出现的异常
                }
                //日志(后置通知，因为可能会出现异常，所以访问不到方法的返回值)
//                System.out.println("The method" + methdoName +"end with" + result);
                return 0;
            }
        };
        proxy = (Calculator) Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }
}
