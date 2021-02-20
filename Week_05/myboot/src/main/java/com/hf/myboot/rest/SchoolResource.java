package com.hf.myboot.rest;

import com.hf.myboot.service.ISchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hfzhang
 * @date 2021/2/20
 */
@RestController
public class SchoolResource {

    @Autowired
    private ISchool school;

    @GetMapping("/ding")
    public String ding() {
        school.ding();
        return "success";
    }
}
