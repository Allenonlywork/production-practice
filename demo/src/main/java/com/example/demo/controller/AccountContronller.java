package com.example.demo.controller;

import com.example.demo.po.Member;
import com.example.demo.po.Nav;
import com.example.demo.service.AccountService;
import com.example.demo.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AccountContronller {

    @Autowired
    private AccountService accountService;

    @Autowired
    private NavService navService;

    @RequestMapping("/account")
    public String account(Model model){
        List<Nav> nav = navService.getNav();
        model.addAttribute("nav",nav);
        return "account";
    }
    @RequestMapping("/contact")
    public String contact(Model model){
        List<Nav> nav = navService.getNav();
        model.addAttribute("nav",nav);
        return "contact";
    }
    @RequestMapping("/login")
    public String login(String name, String pass, HttpSession session){
        Member member = accountService.login(name,pass);
        if(member != null){
            System.out.println("登录成功");
            session.setAttribute("member",member);
        }else {
            System.out.println("登录失败");
        }
        return "redirect:/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}
