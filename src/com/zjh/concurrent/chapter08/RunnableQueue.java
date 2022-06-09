package com.zjh.concurrent.chapter08;

public interface RunnableQueue {
    //当新的任务进来时首先offer到队列中
    void offer(Runnable runnable);

    //工作线程通过take方法获取Runnable  throws InterruptedException
    Runnable take() throws InterruptedException;

    //获取任务队列中任务的数量
    int size();
}
