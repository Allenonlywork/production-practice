package com.neutraining.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mchange.v2.codegen.bean.SerializableExtension;
import com.neutraining.service.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//请求的乱码问题解决
		req.setCharacterEncoding("utf-8");
		//响应的乱码问题解决
		resp.setContentType("text/html;charset=utf-8");
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			LoginService loginservice = new LoginService();
			HttpSession session = req.getSession();
			boolean flag = loginservice.login(username,password,session);
			if(flag) {
				//HttpSession session = req.getSession();
				/*session.setAttribute("user", user);*/
				resp.sendRedirect("index");
				System.out.println("登录成功");
				
				
			}else {
				req.setAttribute("username", username);
				req.setAttribute("password", password);
				req.setAttribute("msg", "用户名或密码错误");
				System.out.println("登陆失败");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
