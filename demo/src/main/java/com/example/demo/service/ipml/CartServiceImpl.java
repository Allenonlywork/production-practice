package com.example.demo.service.ipml;

import com.example.demo.dao.AddressMapper;
import com.example.demo.dao.CartMapper;
import com.example.demo.po.Address;
import com.example.demo.po.Cart;
import com.example.demo.po.CartDetail;
import com.example.demo.po.ProductInCart;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private AddressMapper addressMapper;
    @Override
    public List<ProductInCart> queryByMid(Integer mid) {
        return cartMapper.queryByMid(mid);
    }

    @Override
    public int add2Cart(Integer mid, Integer pid, Integer quantity) {
        Map<String,Object> param = new HashMap<>();

        param.put("mid",mid);
        param.put("pid",pid);
        param.put("quantity",quantity);

        /*先查询用户的购物车中是否由此商品*/
        Cart cart = cartMapper.queryByMidAndPid(param);
        if(cart != null){
            //如果cart 不为空 则有此商品
            return cartMapper.doUpdate(param);
        }
        return cartMapper.doInsert(param);
    }

    @Override
    public int delete(Integer mid, Integer pid) {
        Map<String,Object> param = new HashMap<>();
        param.put("mid",mid);
        param.put("pid",pid);
        return cartMapper.doDelete(param);
    }

    @Override
    public CartDetail queryTotal(Integer mid) {
        return cartMapper.queryTotal(mid);
    }

    @Override
    public List<Address> queryAddressByMid(Integer mid) {
        return addressMapper.queryByMid(mid);
    }

    @Override
    public int updateQuantity(Integer mid, Integer pid, Integer quantity) {
        Map<String,Object> param = new HashMap<>();
        param.put("mid",mid);
        param.put("pid",pid);
        param.put("quantity",quantity);
        return cartMapper.doUpdate(param);
    }
}
