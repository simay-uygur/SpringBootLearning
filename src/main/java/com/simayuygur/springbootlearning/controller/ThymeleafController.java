package com.simayuygur.springbootlearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf1")
    @ResponseBody
    public String getThymeleaf1() {
        return "thymeleaf1";
    }

    @GetMapping("/thymeleaf2")
    public String getThymeleaf2(Model model) {
        model.addAttribute("key_model", "I came from the model ");
        return "thymeleaf2";
    }

    //forgot to write productdto and initialize with a builder
    @GetMapping({"/", "thymeleaf3"}) //index
    public String getThymeleaf3(Model model) {
        model.addAttribute("key_model2", "how are you");
        return "thymeleaf3";
    }

    @GetMapping({"/hymeleaf4", "/thymeleaf4/{id}"}) //index
    public String getThymeleaf4(Model model , @PathVariable(name = "id", required = false) Long id) {
        if(id != null) {
            model.addAttribute("key_model4", "how are you this website's id is  " +id);
        }
        model.addAttribute("key_model2", "welcome to thymeleaf4");
        return "thymeleaf4";
    }

    //http://localhost:8080/thymeleaf5?id=4&nameEntered=SimayUygur
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5ModelObject(Model model, @RequestParam(name = "id" ,required = false, defaultValue = "0") Long id, @RequestParam(name = "nameEntered" ) String nameEntered) {
        if(id != null) {
            model.addAttribute("key_model2", "welcome to thymeleaf5 site's id is " + id + " and name is " + nameEntered );
        } else {
            model.addAttribute("key_model2", "welcome to thymeleaf5 and id COULD NOT FOUND!!!" );
        }

        return "thymeleaf5";
    }



}
