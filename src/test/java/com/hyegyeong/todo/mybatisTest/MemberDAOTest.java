package com.hyegyeong.todo.mybatisTest;

import com.hyegyeong.todo.dao.MemberDAO;
import com.hyegyeong.todo.dto.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/applicationContext.xml"})
public class MemberDAOTest {

    @Inject
    private MemberDAO memberDAO;

    //현재시간 출력 테스트
    @Test
    public void testTime() throws Exception {
        System.out.println(memberDAO.getTime());
    }

    //회원가입 테스트
    @Test
    public void testInsertMember() throws Exception {
        MemberVO memberVO = new MemberVO();
        memberVO.setUserid("user01");
        memberVO.setUserpw("user01");
        memberVO.setUsername("user01");
        memberVO.setEmail("user01@mail.com");

        memberDAO.insertMember(memberVO);
    }

    //회원 조회 테스트 ; 아이디로
    @Test
    public void testReadMember() throws Exception {
        memberDAO.readMember("user00");
    }

    //회원 조회 테스트 ; 아이디 + 패스워드
    @Test
    public void testReadWithPW() throws Exception {
        memberDAO.readWithPW("user00", "user00");
    }
}
