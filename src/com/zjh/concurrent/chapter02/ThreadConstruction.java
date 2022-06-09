package com.zjh.concurrent.chapter02;

public class ThreadConstruction {
    public static void main(String[] args){
//        Thread t1 = new Thread("t1");
//
//        ThreadGroup group = new ThreadGroup("TestGroup");
//
//        Thread t2 = new Thread("t2");
//
//        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
//
//        System.out.println(t1.getThreadGroup());
//        System.out.println(t2.getThreadGroup());
//        System.out.println(mainThreadGroup);

        if(args.length<1){
            System.out.println("enter stacksize plz");
            System.exit(-1);
        }
        final ThreadGroup threadGroup = new ThreadGroup("test");
        final Runnable runnable = new Runnable() {
            final int MAX = Integer.MAX_VALUE;

            @Override
            public void run() {
                int i = 0;
                recurse(i);
            }

            private void recurse(int i) {
                System.out.println(i);
                if (i < MAX) {
                    recurse(i + 1);
                }
            }


        };

        final Thread test = new Thread(threadGroup, runnable, "test", Integer.parseInt(args[0]));
        test.start();

    }
}
