package com.example.demo.service;

import com.example.demo.po.OrderItem;

import java.util.List;

public interface OrderService {
    List<OrderItem> queryByMid(Integer mid);
    int checkout(Integer mid,Integer aid);
}
