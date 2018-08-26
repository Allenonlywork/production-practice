package com.example.demo.service.ipml;

import com.example.demo.dao.MemberMapper;
import com.example.demo.po.Member;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private MemberMapper memberMapper;


    @Override
    public Member login(String name, String pass) {
        Map<String,Object> param = new HashMap<>();
        param.put("name",name);
        param.put("pass",pass);
        return memberMapper.query(param);
    }
}
