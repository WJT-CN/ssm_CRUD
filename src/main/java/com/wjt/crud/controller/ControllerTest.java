package com.wjt.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {
    @RequestMapping("/index")
    public String test(){
        return "index";
    }
}
