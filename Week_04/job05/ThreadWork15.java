package com.hf.job05;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author hfzhang
 * @date 2021/2/4
 */
public class ThreadWork15 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        //如果不指定线程池默认使用ForkJoinPool.commonPool()
        CompletableFuture<Void> integerCompletableFuture = CompletableFuture.runAsync(() -> {
            handler();
        });

        //也可以指定线程池
//        ExecutorService executorService = new ThreadPoolExecutor(2,2,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
//        CompletableFuture<Void> integerCompletableFuture = CompletableFuture.runAsync(() -> {
//            handler();
//        }, executorService);

        //runAsync没有返回值，输出为null
        System.out.println("异步输出结果："+integerCompletableFuture.get());
        //如果指定了线程池得关闭
//        executorService.shutdown();
        System.out.println("线程："+Thread.currentThread().getName()+" 使用时间："+(System.currentTimeMillis()-start)+"ms");
    }

    private static int handler() {
        int result = Compute.fibo(7);
        System.out.println("线程："+Thread.currentThread().getName()+" 异步计算结果："+result);
        return result;
    }
}
