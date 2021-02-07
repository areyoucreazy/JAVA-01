package com.hf.job05;

import java.util.concurrent.*;

/**
 * ExecutorService.submit+Future.get()阻塞 线程池方式
 * @author hfzhang
 * @date 2021/2/4
 */
public class ThreadWork11 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        ExecutorService executorService = new ThreadPoolExecutor(2,2,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return handler();
            }
        });

        try {
            System.out.println("异步线程输出结果："+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("线程："+Thread.currentThread().getName()+" 使用时间："+(System.currentTimeMillis()-start)+"ms");
    }

    private static int handler() {
        int result = Compute.fibo(7);
        System.out.println("线程："+Thread.currentThread().getName()+" 异步计算结果："+result);
        return result;
    }

}
