package com.zjh.concurrent.chapter01;

import java.util.concurrent.TimeUnit;
public class TryConcurrency {
    public static void main(String[] args) {
//        version 1.0单线程——browseNews抢占线程
//        browseNews();
//        enjoyMusic();

//        version2.0 并发运行
//        new Thread(){
//            @Override
//            public void run() {
//                enjoyMusic();
//            }
//        }.start();
//        browseNews();
//        version2.1 lambda
        new Thread(TryConcurrency::enjoyMusic).start();
        browseNews();

    }

    private static void browseNews(){
        for(;;){
            System.out.println("good News!");
            sleep(1);
        }
    }

    private static void enjoyMusic(){
        for(;;){
            System.out.println("nice Music！");
            sleep(1);
        }
    }

    private static void sleep(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
