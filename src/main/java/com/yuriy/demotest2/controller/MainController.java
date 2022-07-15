package com.yuriy.demotest2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping
public class MainController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
