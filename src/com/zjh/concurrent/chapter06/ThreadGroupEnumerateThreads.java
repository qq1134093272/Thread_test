package com.zjh.concurrent.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupEnumerateThreads {
    public static void main(String[] args) throws InterruptedException{
        ThreadGroup myGroup = new ThreadGroup("myGroup");
        Thread thread=new Thread(myGroup,()->{
           while (true){
               try {
                   TimeUnit.SECONDS.sleep(1);
               }catch (InterruptedException e){

               }
           }
        },"myThread");
        thread.start();
//        保证两个线程不同时创建
        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();

        Thread[] list=new Thread[threadGroup.activeCount()];
        int recurseSize = threadGroup.enumerate(list);
        System.out.println(recurseSize);

        recurseSize=threadGroup.enumerate(list,false);
        System.out.println(recurseSize);
    }
}
