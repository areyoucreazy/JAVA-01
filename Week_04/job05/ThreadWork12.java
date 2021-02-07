package com.hf.job05;

import java.util.concurrent.*;

/**
 * 线程池+synchronized  方式，下面要么同时锁住oo，要么同时锁住mainThread,，一个意思
 * @author hfzhang
 * @date 2021/2/4
 */
public class ThreadWork12 {

    public static void main(String[] args) {
        Object oo = new Object();
        Thread mainThread = Thread.currentThread();
        long start = System.currentTimeMillis();
        ExecutorService executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                handler(oo, mainThread);
            }
        });
        executorService.shutdown();
        synchronized (mainThread){
            try {
                mainThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程："+Thread.currentThread().getName()+" 使用时间："+(System.currentTimeMillis()-start)+"ms");
    }

    private static int handler(Object oo, Thread mainThread) {
        int result = Compute.fibo(7);
        System.out.println("线程："+Thread.currentThread().getName()+" 异步计算结果："+result);
        synchronized (mainThread){
            mainThread.notify();
        }
        return result;
    }

}
