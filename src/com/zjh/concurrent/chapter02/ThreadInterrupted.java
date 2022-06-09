package com.zjh.concurrent.chapter02;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupted {
    public static void main(String[] args) throws InterruptedException{
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.out.println(interrupted());
//                }
//            }
//        };
//        thread.setDaemon(true);
//        thread.start();
//        TimeUnit.MILLISECONDS.sleep(1);
////        System.out.println(thread.isInterrupted());
//        thread.interrupt();
////        TimeUnit.MILLISECONDS.sleep(1);
////        System.out.println(thread.isInterrupted());
//        Thread t=new Thread("12");
        Thread.interrupted();
        Thread t=Thread.currentThread();
        Thread.currentThread().interrupt();
        System.out.println(t.isInterrupted());
        try {
            TimeUnit.MILLISECONDS.sleep(2);
        }catch (InterruptedException e){
            System.out.println("get it!");
        }
    }
}
