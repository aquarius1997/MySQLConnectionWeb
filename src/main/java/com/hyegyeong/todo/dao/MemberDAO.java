package com.hyegyeong.todo.dao;

import com.hyegyeong.todo.dto.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface MemberDAO {

    //현재시간 조회
    public String getTime();

    //회원 입력
    public void insertMember(MemberVO memberVO);

    //회원 아이디로 조회
    public MemberVO readMember(String userid) throws Exception;

    //회원 아이디, 비밀번호로 조회
    public MemberVO readWithPW(String userid, String userpw) throws Exception;

}
