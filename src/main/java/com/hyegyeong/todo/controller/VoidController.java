package com.hyegyeong.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class VoidController {

   // private static final Logger logger = LoggerFactory.getLogger(VoidController.class);

    @RequestMapping("/doA")
    public void doA() {
        log.info("/doA called...");
        log.info("add spring loaded");
    }

    @RequestMapping("/doB")
    public void doB() {
        log.info("/doB called...");
    }

}
