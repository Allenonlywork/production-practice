package com.example.demo.service;

import com.example.demo.po.Member;

public interface AccountService {
    Member login(String name,String pass);
}
