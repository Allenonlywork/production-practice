package com.example.demo.service;


import com.example.demo.po.Product;
import com.example.demo.po.ProductPage;

public interface ProductService {
    ProductPage query(Integer cid, Integer bid, String keyWord, Integer page);
    Product queryByPid(Integer pid);
}
