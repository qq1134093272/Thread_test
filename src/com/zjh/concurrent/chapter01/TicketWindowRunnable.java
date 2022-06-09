package com.zjh.concurrent.chapter01;

import java.util.stream.IntStream;

public class TicketWindowRunnable implements Runnable{
    private int index=1;
    private final static int MAX=50;
    @Override
    public void run() {
        while (index<=MAX){
            System.out.println(Thread.currentThread()+"的号码是："+(index++));
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
//        final TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();
//        Thread thread1 = new Thread(ticketWindowRunnable, "柜台1");
//        Thread thread2 = new Thread(ticketWindowRunnable, "柜台2");
//        Thread thread3 = new Thread(ticketWindowRunnable, "柜台3");
//        Thread thread4 = new Thread(ticketWindowRunnable, "柜台4");

//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();


//        IntStream.range(0,5).boxed().map(i->new Thread(
//                ()->System.out.println(Thread.currentThread().getName())
//        )).forEach(Thread::start);

//        IntStream.range(0,5).mapToObj(ThreadConstruction)



    }
}
