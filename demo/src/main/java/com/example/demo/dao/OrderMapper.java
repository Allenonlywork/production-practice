package com.example.demo.dao;

import com.example.demo.po.OrderItem;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    List<OrderItem> queryByMid(Integer mid);
    int doInsert(Map<String,Object> param);
    int doInsertDetail(List<Map<String,Object>> params);
}
