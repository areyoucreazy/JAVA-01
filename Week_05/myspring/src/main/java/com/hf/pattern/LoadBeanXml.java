package com.hf.pattern;

import com.hf.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hfzhang
 * @date 2021/2/19
 */
public class LoadBeanXml {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = (Student)applicationContext.getBean("student1");
        System.out.println(student1);

        Student student2 = (Student)applicationContext.getBean("student2");
        System.out.println(student2);
    }
}
