package com.zjh.concurrent.chapter08;

public class InternalTask implements Runnable{
    private final RunnableQueue runnableQueue;
    private volatile boolean running=true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
//        this.running = running;
    }

    @Override
    public void run() {
        //如果当前任务为running并且没有被中断，则其将不断地从queue中获取runnable，之后执行run
        while (running&&!Thread.currentThread().isInterrupted()){
            try {
                Runnable task = runnableQueue.take();
                task.run();
            }catch (InterruptedException e){
                running=false;
                break;
            }
        }
    }
    //停止当前线程，一般在线程销毁、线程数量维护时使用
    public void stop(){
        this.running=false;
    }
}
