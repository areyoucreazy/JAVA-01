package com.hf.job05;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock+Condition
 * @author hfzhang
 * @date 2021/2/3
 */
public class ThreadWork05 {

    private final static ReentrantLock reentrantLock = new ReentrantLock(true);
    private final static Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Object obj = new Object();
        //异步执行
        new Thread(() -> {
            ThreadWork05.handler(obj);
        }).start();
        ThreadWork05.mainHandler(start);
    }

        private static void mainHandler(long start) throws InterruptedException {

            try {
                reentrantLock.lock();
                condition.await();
                System.out.println("线程："+Thread.currentThread().getName()+" 使用时间："+(System.currentTimeMillis()-start)+"ms");
            }finally {
                reentrantLock.unlock();
            }
        }

    private static void handler(Object obj) {
        try {
            reentrantLock.lock();
            int result = Compute.fibo(7);
            System.out.println("线程："+Thread.currentThread().getName()+" 异步计算结果："+result);
            condition.signal();
        }finally {
            reentrantLock.unlock();
        }

    }
}
