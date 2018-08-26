package com.example.demo.dao;

import com.example.demo.po.Address;

import java.util.List;

public interface AddressMapper {
    List<Address> queryByMid(Integer mid);
}
