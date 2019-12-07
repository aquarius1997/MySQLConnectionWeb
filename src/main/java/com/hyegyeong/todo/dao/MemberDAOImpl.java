package com.hyegyeong.todo.dao;

import com.hyegyeong.todo.dto.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;


//헤딩 파일때문에 프로젝트 빌드안됨.
@Repository
public class MemberDAOImpl implements MemberDAO {

    @Inject
    private SqlSession sqlSession;

    private static final String NAMESPACE = "com.hyegyeong.todo.mappers.memberMapper";

    @Override
    public String getTime() {
        return sqlSession.selectOne(NAMESPACE + ".getTime");
    }

    @Override
    public void insertMember(MemberVO memberVO) {
        sqlSession.insert(NAMESPACE + ".insertMember", memberVO);
    }

    @Override
    public MemberVO readMember(String userid) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".selectMember", userid);
    }

    @Override
    public MemberVO readWithPW(String userid, String userpw) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userid", userid);
        paramMap.put("userpw", userpw);
        return sqlSession.selectOne(NAMESPACE + ".readWithPW", paramMap);
    }
}
