package com.example.demo.dao;

import com.example.demo.po.Cart;
import com.example.demo.po.CartDetail;
import com.example.demo.po.ProductInCart;

import java.util.List;
import java.util.Map;

public interface CartMapper {
    List<ProductInCart> queryByMid(Integer mid);

    int doInsert(Map<String,Object> param);

    Cart queryByMidAndPid(Map<String,Object> param);

    int doUpdate(Map<String,Object> param);

    int doDelete(Map<String,Object> param);

    CartDetail queryTotal(Integer mid);

    int remove(Integer mid);
}
