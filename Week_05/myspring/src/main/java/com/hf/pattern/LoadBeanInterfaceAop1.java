package com.hf.pattern;

import com.hf.aop.ISchool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hfzhang
 * @date 2021/2/19
 */
public class LoadBeanInterfaceAop1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ISchool school = applicationContext.getBean(ISchool.class);
        System.out.println(school);
        System.out.println("ISchool接口的对象AOP代理后的实际类型："+school.getClass());

        ISchool school1 = applicationContext.getBean(ISchool.class);
        System.out.println(school1);
        System.out.println("ISchool接口的对象AOP代理后的实际类型："+school1.getClass());

        school1.ding();
    }
}
