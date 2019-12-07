package com.hyegyeong.todo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MemberVO {

    private String userid;
    private String userpw;
    private String username;
    private String email;
    private Date regdate;
    private Date updatedate;

}
