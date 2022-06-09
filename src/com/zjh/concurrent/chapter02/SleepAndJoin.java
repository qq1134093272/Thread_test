package com.zjh.concurrent.chapter02;


import java.util.concurrent.TimeUnit;
//结果:(退出代码块才进入test2方法，证明sleep(long)没有释放锁)
public class SleepAndJoin extends Thread {

//    private static final Logger LOGGER = LoggerFactory.getLogger(SleepAndJoin.class);
static class Join extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    public Join() {
    }

    public Join(String name) {
        super(name);
    }

    public synchronized void test2() {
            System.out.printf("进入test2方法，占有锁，threadname->%s\n", currentThread().getName());
        }


    }

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("main");
//        LOGGER.info("main start");
        final SleepAndJoin sleepAndJoin = new SleepAndJoin();
        final Join jojo=new Join("jojo");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (jojo) {
//                        LOGGER.info("进入同步代码块，threadName ->{} 占有 jojo 的锁", Thread.currentThread().getName());
                        System.out.printf("进入同步代码块，threadName ->%s 占有 %s 的锁\n", Thread.currentThread().getName(),jojo.getName());
                        jojo.start();
                        //jojo加入父线程ThreadB中
                        jojo.join(4 * 1000);
                        System.out.printf("退出同步代码块，threadName ->%s,释放 %s 的锁\n", Thread.currentThread().getName(),jojo.getName());

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"ThreadB").start();

//        // 启动demo4线程并且占用锁之后调用join(long)方法
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    synchronized (sleepAndJoin) {
////                        LOGGER.info("进入同步代码块，threadName ->{} 占有 sleepAndJoin 的锁", Thread.currentThread().getName());
//                        System.out.printf("进入同步代码块，threadName ->%s 占有 sleepAndJoin 的锁\n", Thread.currentThread().getName());
//                        sleepAndJoin.start();
//                        TimeUnit.MILLISECONDS.sleep(4 * 1000);
//                        System.out.printf("退出同步代码块，threadName ->%s\n", Thread.currentThread().getName());
//
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "threadA").start();
//
        // 休眠2秒钟，调用对象的同步方法
        TimeUnit.MILLISECONDS.sleep(2 * 1000);
        sleepAndJoin.test2();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test2() {
        System.out.printf("进入test2方法，占有锁，threadname->%s\n", currentThread().getName());
    }
}
