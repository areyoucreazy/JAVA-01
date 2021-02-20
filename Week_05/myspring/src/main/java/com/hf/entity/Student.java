package com.hf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author hfzhang
 * @date 2021/2/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int id;
    private String name;

    public void init() {
        System.out.println("hello..............");
    }

    public Student create(){
        return new Student(101, "KK1");
    }

}
