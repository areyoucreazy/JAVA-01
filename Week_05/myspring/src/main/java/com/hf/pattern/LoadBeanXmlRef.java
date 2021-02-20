package com.hf.pattern;

import com.hf.entity.Klass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hfzhang
 * @date 2021/2/19
 */
public class LoadBeanXmlRef {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Klass klass = applicationContext.getBean(Klass.class);
        System.out.println(klass);
        System.out.println("Klass对象AOP代理后的实际类型："+klass.getClass());
        System.out.println("Klass对象AOP代理后的实际类型是否是Klass子类："+(klass instanceof Klass));
        klass.dong();
    }
}
