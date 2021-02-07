package com.hf.job05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask+异步线程启动+future.get()阻塞方式
 * @author hfzhang
 * @date 2021/2/4
 */
public class ThreadWork13 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return handler();
            }
        });
        //异步启动
        new Thread(futureTask).start();
        try {
            System.out.println("异步线程输出结果："+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("线程："+Thread.currentThread().getName()+" 使用时间："+(System.currentTimeMillis()-start)+"ms");
    }

    private static int handler() {
        int result = Compute.fibo(7);
        System.out.println("线程："+Thread.currentThread().getName()+" 异步计算结果："+result);
        return result;
    }

}
