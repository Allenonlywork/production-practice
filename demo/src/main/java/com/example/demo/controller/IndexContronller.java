package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.po.CartDetail;
import com.example.demo.po.Nav;
import com.example.demo.service.CartService;
import com.example.demo.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 控制层
 */
@Controller
public class IndexContronller {

    @Autowired
    private NavService navService;

    @RequestMapping("/index")
    public String index(Model model){
        List<Nav>  nav= navService.getNav();
        System.out.println(JSON.toJSONString(nav));
        //将查询到的导航数据存入request作用域
        model.addAttribute("nav",nav);
        return "index";
    }

}
