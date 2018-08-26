package com.example.demo.controller;

import com.example.demo.po.Nav;
import com.example.demo.po.Product;
import com.example.demo.service.NavService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private NavService navService;

    @RequestMapping("/product/{pid}")
    public String product(Model model, @PathVariable Integer pid){
        System.out.println("pid = [" + pid + "]");
        List<Nav> nav= navService.getNav();
        Product product = productService.queryByPid(pid);
        model.addAttribute("product",product);
        model.addAttribute("nav",nav);
        return "product";
    }
}
