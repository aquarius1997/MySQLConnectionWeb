package com.hyegyeong.todo.controller;

import com.hyegyeong.todo.dto.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DomainController {

    @RequestMapping("/doD")
    public String doD(Model model) {

        ProductVO product = new ProductVO("desktop", 30000);
        log.info("/doD called");
        model.addAttribute(product);

        return "product_detail";
    }

}
