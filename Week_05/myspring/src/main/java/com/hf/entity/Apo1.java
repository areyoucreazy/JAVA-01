package com.hf.entity;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author hfzhang
 * @date 2021/2/19
 */
public class Apo1 {

    //前置通知
    public void startTransaction() {
        System.out.println("----begin ding....  ");
    }
    //后置通知
    public void commitTransaction() {
        System.out.println("----finish ding... ");
    }
    //环绕通知
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(" ----around begin ding... ");

        //调用process()方法才会真正的执行实际被代理的方法
        joinPoint.proceed();

        System.out.println(" ----around end ding... ");
    }
}
