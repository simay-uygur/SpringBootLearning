package com.simayuygur.springbootlearning.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class BeanDto {
    private Long id;
    private String beanName;
    private String beanData;


    //start
    public void initialBeanMethod(){
        log.info("BeanDto initialBeanMethod   before bean started, this method exist");
        System.out.println("before bean started, this method exist");
    }


    //end
    public void destroyBeanMethod(){
        log.info("BeanDto initialBeanMethod   after bean ended, this method exist");
        System.out.println("after bean ended, this method exist");
    }
}
