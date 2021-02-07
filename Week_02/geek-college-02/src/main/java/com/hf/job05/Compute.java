package com.hf.job05;

/**
 * @author hfzhang
 * @date 2021/2/3
 */
public class Compute {

    public static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }

}
