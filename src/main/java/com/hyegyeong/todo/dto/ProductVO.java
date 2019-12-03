package com.hyegyeong.todo.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class ProductVO {

    private String name;
    private double price;

}
