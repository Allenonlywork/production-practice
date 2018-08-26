package com.example.demo.dao;

import com.example.demo.po.Product;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    /**
     * 多条件查询商品
     */
    List<Product> query(Map<String,Object> param);
    /**
     * 根据pid查询商品
     * @param pid 商品的id
     * @return 查询出的商品
     */
    Product queryByPid(Integer pid);

    int doUpdate(Map<String,Object> param);
}
