package com.hf.entity;

import lombok.Data;

import java.util.List;

/**
 * @author hfzhang
 * @date 2021/2/19
 */
@Data
public class Klass {
    private List<Student> studentList;

    public void dong(){
        System.out.println(this.studentList);
    }
}
