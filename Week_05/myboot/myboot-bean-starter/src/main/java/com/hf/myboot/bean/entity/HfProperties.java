package com.hf.myboot.bean.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hfzhang
 * @date 2021/2/20
 */
@ConfigurationProperties(prefix = "hf")
@Data
public class HfProperties {
    private String sayWords;
    private String toBody;
}
