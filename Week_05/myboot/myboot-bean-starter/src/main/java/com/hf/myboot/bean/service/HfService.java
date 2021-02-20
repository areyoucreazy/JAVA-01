package com.hf.myboot.bean.service;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hfzhang
 * @date 2021/2/20
 */
@Data
@AllArgsConstructor
public class HfService {
    public String sayWords;
    public String toBody;

    public String say(){
        return this.sayWords+"!"+this.toBody;
    }
}
