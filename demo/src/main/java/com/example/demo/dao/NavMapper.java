package com.example.demo.dao;

import com.example.demo.po.Nav;

import java.util.List;

public interface NavMapper {
    /**
     * 查询出导航中的分类以及分类对应的品牌
     * @return
     */
    List<Nav> getNav();
}
