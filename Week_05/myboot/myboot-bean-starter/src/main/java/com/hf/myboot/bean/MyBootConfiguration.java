package com.hf.myboot.bean;

import com.hf.myboot.bean.entity.HfProperties;
import com.hf.myboot.bean.service.HfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hfzhang
 * @date 2021/2/20
 */
@Configuration
@EnableConfigurationProperties(HfProperties.class)
@ConditionalOnProperty(prefix = "hf",name = "isopen",havingValue = "true")
public class MyBootConfiguration {
    @Autowired
    private HfProperties hfProperties;

    @Bean(name = "hf")
    public HfService hfService() {
        return new HfService(hfProperties.getSayWords(), hfProperties.getToBody());
    }
}
