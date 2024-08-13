package com.simayuygur.springbootlearning.controller;

import com.simayuygur.springbootlearning.bean.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeanController {
//instead of inject we use autowired
    @Autowired
    BeanConfig beanConfig;

    //http://localhost:8080/ bean/beanDto
    @GetMapping("/bean/beanDto")
    @ResponseBody  // show it on the monitor without html
    public String getBean(){
        return beanConfig.beanDto()+".";
    }

}
