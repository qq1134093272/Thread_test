package com.zjh.concurrent.chapter04;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class ThisMonitor {
    public synchronized void method1(){
        System.out.println(currentThread().getName()+" enter method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

//    public synchronized void method2(){
//        System.out.println(currentThread().getName()+" enter method2");
//        try {
//            TimeUnit.MINUTES.sleep(10);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//与上述结果一致=》synchronized修饰代码块
    public void method2(){
        synchronized (this){
            System.out.println(currentThread().getName()+" enter method2");
            try {
                TimeUnit.MINUTES.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ThisMonitor thisMonitor=new ThisMonitor();
        new Thread(thisMonitor::method1,"t1").start();
        new Thread(thisMonitor::method2,"t2").start();

    }
}
