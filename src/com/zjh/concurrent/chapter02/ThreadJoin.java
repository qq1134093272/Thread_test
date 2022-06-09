package com.zjh.concurrent.chapter02;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        //创建两个线程，保存在list中
        List<Thread> threads = IntStream.range(1, 3).mapToObj(ThreadJoin::create).collect(Collectors.toList());

        threads.forEach(Thread::start);

//        threads.forEach(Thread::);

        //        执行join方法
        for(Thread t:threads){
            t.join();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("thread name:" + Thread.currentThread().getName() + "#" + i);
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static Thread create(int index) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("thread name:" + Thread.currentThread().getName() + "#" + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        });

    }
}
