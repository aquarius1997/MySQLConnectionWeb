package com.hyegyeong.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class RedirectController {

    @RequestMapping("/doE")
    public String doE(RedirectAttributes redirectAttributes) {
        log.info("/doE called and redirect to /doF");
        redirectAttributes.addAttribute("msg", "this is the message with redirected");
        return "redirect:/doF";
    }

    @RequestMapping("/doF")
    public void doF(@ModelAttribute String msg) {
        log.info("/doF called" + msg);
    }

}
