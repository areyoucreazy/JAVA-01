package com.hf.entity;

import com.hf.aop.ISchool;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author hfzhang
 * @date 2021/2/19
 */
@Data
public class School implements ISchool {

    @Autowired(required = true)
    Klass klass;

    @Resource(name = "student1")
    Student student1;

    public void ding() {
        System.out.println("Class1 have " + this.klass.getStudentList().size() + " students and one is " + this.student1);
    }
}
