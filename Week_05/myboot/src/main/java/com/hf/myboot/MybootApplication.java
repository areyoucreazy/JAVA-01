package com.hf.myboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hfzhang
 * @date 2021/2/20
 */
@SpringBootApplication
//@EnableJms   //启动消息队列
//@EnableMongoRepositories
public class MybootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybootApplication.class, args);
    }
}
