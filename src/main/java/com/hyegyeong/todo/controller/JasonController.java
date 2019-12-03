package com.hyegyeong.todo.controller;

import com.hyegyeong.todo.dto.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class JasonController {

    @RequestMapping(value="/doJson", method = RequestMethod.GET)
    @ResponseBody
    public ProductVO doJson() {
        ProductVO productVO = new ProductVO("laptop", 500000);
        log.info("doJson...");

        return productVO;
    }
}
