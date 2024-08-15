package com.simayuygur.springbootlearning.controller;

import com.simayuygur.springbootlearning.dto.TeacherDto;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class FormController {

//    @GetMapping
//    @PostMapping
//    @PutMapping
//    @DeleteMapping

    //http://localhost:8080/form
    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("cv_teacher" , new TeacherDto());
        return"form_post/formvalidation";
    }

    @PostMapping("/form")
    public String postForm(@Valid @ModelAttribute("cv_teacher") TeacherDto teacherDto, BindingResult bindingResult ) {
        if(bindingResult.hasErrors()) {
            log.error( "There is an error. ");
            System.out.println("there is an error. ");
            return "form_post/formvalidation";
        }

        log.info("Success " + teacherDto);

        //database  upload =====> hw    filewriter preparedstatement
        //writing to a folder

        return"form_post/success";
    }
}

