package com.zjh.concurrent.chapter05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

public class BooleanLockTest {

    private final Lock lock=new BooleanLock();

    public  void syncMethod() {
        try{
            lock.lock();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            int randomInt = current().nextInt();
            System.out.println(currentThread()+"get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void syncMethodTimeoutable() {
        try {
            lock.lock(1000L);
            System.out.println(currentThread()+"get the lock");
            int randomInt = current().nextInt();
            TimeUnit.SECONDS.sleep(randomInt);
        }catch (InterruptedException | TimeoutException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        BooleanLockTest blt = new BooleanLockTest();
//        for(int i=0;i<10;i++){
//            new Thread(blt::syncMethod).start();
//        }
        IntStream.range(0,10)
                .mapToObj(i->new Thread(blt::syncMethod))
                .forEach(Thread::start);
    }
}
