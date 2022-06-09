package com.zjh.concurrent.chapter07;

import java.util.concurrent.TimeUnit;

public class EmptyExceptionHandler {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        final Thread thread=new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){

            }

            System.out.println(1/0);

        },"Test-Thread");
        thread.start();

    }
}
