package com.neutraining.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neutraining.model.User;
import com.neutraining.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//请求的乱码问题解决
		req.setCharacterEncoding("utf-8");
		//响应的乱码问题解决
		resp.setContentType("text/html;charset=utf-8");
		//PrintWriter writer = resp.getWriter();
		try {
			String username = req.getParameter("username");
			String realname = req.getParameter("realname");
			String password = req.getParameter("password");
			String gender = req.getParameter("gender");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			
			User user = new User(username,realname,password,gender,phone,email);
			UserService userService = new UserService();
			
			boolean flag = userService.register(user);
			
			if(flag) {
					System.out.println("注册成功");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else {
				System.out.println("注册失败");
				req.setAttribute("msg", "注册失败，请重新注册");
				req.getRequestDispatcher("register.jsp").forward(req, resp);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		//String un = req.getParameter("username");
		//String pwd = req.getParameter("password");
		/*System.out.println("username:" + un);
		System.out.println("password:" + pwd);*/
		
		/*
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test?&user=root&password=123456&serverTimezone=UTC";
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps1 = connection.prepareStatement("select count(*) count from user where username = ?");
			ps1.setString(1, un);
			ResultSet rs = ps1.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count != 0) {
				PrintWriter writer = resp.getWriter();
				writer.write("注册失败");
			}else {
				String sql = "insert into user(username,password) values(?,?)";
				
				PreparedStatement pStatement = connection.prepareStatement(sql);
				
				pStatement.setString(1, un);
				pStatement.setString(2, pwd);
				
				pStatement.executeUpdate();
				pStatement.close();
			}
			connection.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
			
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("调用dopost方法");
		doGet(req, resp);
	}
	
}
