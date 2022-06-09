package com.zjh.concurrent.chapter06;

public class ThreadGroupDestroy {
    public static void main(String[] args) {
        ThreadGroup testGroup = new ThreadGroup("TestGroup");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("group is Destroyed:"+testGroup.isDestroyed());
        mainGroup.list();

        testGroup.destroy();

        System.out.println("group is Destroyed:"+testGroup.isDestroyed());
        mainGroup.list();
    }
}
