package com.neutraining.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neutraining.model.Product;
import com.neutraining.service.ProductService;

@WebServlet("/single")
public class DetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取前台数据
				String pid = req.getParameter("pid");
				try {
					//调用service根据商品id查询该商品信息
					ProductService ps = new ProductService();
					
					Product product = ps.getProductById(pid);
					HttpSession session = req.getSession(true);
					req.setAttribute("product", product);
					req.getRequestDispatcher("single.jsp").forward(req, resp);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
