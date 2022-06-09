package com.zjh.concurrent.chapter05;

import java.util.concurrent.TimeUnit;

public class EventCilent {
    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();
        new Thread(
                ()->{
            for(;;){
                eventQueue.offer(new EventQueue.Event());
            }
        }
        ,"Producer").start();

        new Thread(()->{
            for(;;){
                eventQueue.take();
                try{
                    TimeUnit.SECONDS.sleep(10);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"Consumer").start();
    }
}
