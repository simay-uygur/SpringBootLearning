package com.simayuygur.springbootlearning.bean;

import com.simayuygur.springbootlearning.business.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initialBeanMethod" , destroyMethod = "destroyBeanMethod")
    @Scope("singleton") //other options are session, request
    public BeanDto beanDto(){
        return BeanDto.
                builder().
                    id(0L).beanName("mybean").beanData("bean data").
                build();
    }
}
