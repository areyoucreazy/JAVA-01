package com.hf.myboot.service.impl;

import com.hf.myboot.service.ISchool;
import org.springframework.stereotype.Service;

/**
 * @author hfzhang
 * @date 2021/2/20
 */
@Service
public class School implements ISchool {
    @Override
    public void ding() {
        System.out.println("實現自動裝配。。。。");
    }
}
