package com.zjh.concurrent.chapter01;

import java.util.concurrent.TimeUnit;
public class TryConcurrency {
    public static void main(String[] args) {
        browseNews();
        enjoyMusic();
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
