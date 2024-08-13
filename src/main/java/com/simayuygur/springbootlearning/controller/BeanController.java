package com.simayuygur.springbootlearning.controller;

import com.simayuygur.springbootlearning.bean.BeanConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class BeanController {
//instead of inject we use autowired
    @Autowired
    BeanConfig beanConfig;


    ////////////////////
    @Autowired
    Logger LOG;

    /*
    //constructor without parameter
    this gives error because this.log is null
    public BeanController() {
        LOG.info("log info has been called ");
    }
*/
    @PostConstruct   //the mission: When a bean is created, this method is immediately created.
    public void init(){
        LOG.info("log info invoked ");
    }


    //http://localhost:8080/ bean/beanDto
    @GetMapping("/bean/beanDto")
    @ResponseBody  // show it on the monitor without html
    public String getBean(){
        return beanConfig.beanDto()+".";
    }

    public static void main(String[] args) {
        BeanController beanController = new BeanController();
        System.out.println(beanController);
    }
}
