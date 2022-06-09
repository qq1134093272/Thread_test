package com.zjh.concurrent.chapter08;

public interface ThreadPool {
    //提交任务到线程池
    void execute(Runnable runnable);

    //关闭线程池
    void shutdown();

    //获取线程池的初始大小
    int getInitSize();

    //获取线程池的最大大小
    int getMaxSize();

    //获取线程池的核心线程数量大小
    int getCoreSize();

    //获取线程池的任务缓存队列大小
    int getQueueSize();

    //获取线程池的活跃线程数量
    int getActiveCount();

    //查看当前线程池是否关闭
    boolean isShutdown();

}
