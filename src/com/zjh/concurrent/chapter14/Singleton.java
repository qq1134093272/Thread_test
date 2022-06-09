package com.zjh.concurrent.chapter14;

import java.net.Socket;
import java.sql.Connection;

/**
 * 饿汉模式
 */
//不允许被继承
public final class Singleton {
    private byte[] data=new byte[1024];
    //预先初始化对象
    private static Singleton instance=new Singleton();
    //私有化构造函数
    private Singleton(){

    }

    public static Singleton getInstance(){
        return instance;
    }
}


/**
 * 懒汉模式
 */
final class Singleton2{
    private byte[] data=new byte[1024];
    private static Singleton2 instance=null;
    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        if(null==instance){
            instance=new Singleton2();
        }
        return instance;
    }
}

/**
 * 懒汉式+同步
 */
final class Singleton3{
    private byte[] data=new byte[1024];
    private static Singleton3 instance=null;
    private Singleton3(){

    }

    public static synchronized Singleton3 getInstance(){
        if(null==instance){
            instance=new Singleton3();
        }
        return instance;
    }
}

/**
 * Double-check
 */
final class Singleton4{
    private byte[] data=new byte[1024];
    private static Singleton4 instance=null;
    Connection conn;
    Socket socket;

    private Singleton4(){
//        this.conn;
//        this.socket;
    }

    public static Singleton4 getInstance(){
        //避免重复进入同步代码块，提高效率
        if(null==instance){
            synchronized (Singleton4.class){
                if(null==instance){
                    instance=new Singleton4();
                }
            }

        }
        return instance;
    }
}

/**
 * enum
 */
enum Singleton7{
    INSTANCE;
    private byte[] data=new byte[1024];

    Singleton7(){
        System.out.println("INSTANCE will be initialized immediately");
    }

    public static void method()
    {
        //调用该方法会主动使用Singleton7，INSTANCE将会被实例化
    }

    public static Singleton7 getInstance(){
        return INSTANCE;
    }
}

/**
 * enum+懒加载
 */
class Singleton8{
    private byte[] data=new byte[1024];

    private Singleton8(){
    }

    public enum EnumHolder{
        INSTANCE;
        private Singleton8 instance;
        EnumHolder(){
            this.instance=new Singleton8();
        }

        private Singleton8 getSingleton(){
            return instance;
        }
    }

    public static Singleton8 getInstance(){
        return EnumHolder.INSTANCE.getSingleton();
    }
}