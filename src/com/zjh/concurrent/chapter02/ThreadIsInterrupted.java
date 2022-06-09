package com.zjh.concurrent.chapter02;

import java.util.concurrent.TimeUnit;

public class ThreadIsInterrupted {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        //忽略此异常。清除interrupt标记
                        System.out.println(isInterrupted());


                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(1);
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        TimeUnit.MILLISECONDS.sleep(1);
        System.out.println(thread.isInterrupted());

    }
}
