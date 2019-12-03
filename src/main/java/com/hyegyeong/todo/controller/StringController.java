package com.hyegyeong.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class StringController {

    @RequestMapping("/doC")
    public String test(@ModelAttribute("msg") String msg) {
        log.info("/doC called...");
        return "result";
    }
}
