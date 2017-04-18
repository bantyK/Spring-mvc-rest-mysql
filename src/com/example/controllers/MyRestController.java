package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyRestController {

    @RequestMapping(value = "/test")
    public ModelAndView test(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("msg","banty");
        return model;
    }
}
