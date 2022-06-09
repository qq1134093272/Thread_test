package com.zjh.concurrent.chapter10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException ,IllegalAccessException,InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> aClass = classLoader.loadClass("com.zjh.concurrent.chapter10.He");
        System.out.println(aClass.getClassLoader());//没有导致类的主动初始化，只是执行了加载过程的加载阶段
        Object he = aClass.newInstance();
        System.out.println(he);
        Method welcomeMethod = aClass.getMethod("welcome");
        String result = (String) welcomeMethod.invoke(he);
        System.out.println("Result:"+result);


    }
}
