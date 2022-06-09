package com.zjh.concurrent.chapter08;

@FunctionalInterface
public interface DenyPolicy {
    void  reject(Runnable runnable,ThreadPool threadPool);

    //策略一：直接丢弃任务
    class DiscardDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            //do nothing
        }
    }

    //策略二：会向任务提交者抛出异常
    class AbortDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDenyExceptiom("The runnable "+runnable+" will be abort.");
        }
    }

    //策略三：会使任务在提交者所在的线程中执行任务
    class RunnerDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if(!threadPool.isShutdown()){
                runnable.run();
            }
        }
    }
}
