package com.zjh.concurrent.chapter02;

public class FlagThreadExit {
    static class MyTask extends Thread{
        private volatile boolean closed=false;

        @Override
        public void run() {
            System.out.println("start work!");
            while (!closed&&!isInterrupted()){
                //working
            }
            System.out.println("will exit");

        }

        public void close(){
            this.closed=true;
            this.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        task.start();
        Thread.sleep(1_00L);
        System.out.println("shutdown");
        task.close();


    }
}
