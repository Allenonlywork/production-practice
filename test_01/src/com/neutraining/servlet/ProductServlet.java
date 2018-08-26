package com.neutraining.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neutraining.model.Category;
import com.neutraining.service.CategoryService;
import com.neutraining.service.ProductService;
import com.neutraining.model.Product;;


@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//调用业务层，查询所有商品类型
			CategoryService cs = new CategoryService();
			//查询所有商品类型
			List<Category> categorys = cs.getAllList();
			
			ProductService ps = new ProductService();
			List<Product> products = ps.getAllList();
			HttpSession session = req.getSession(true);
			System.out.println(products);
			req.setAttribute("categorys", categorys);
			req.setAttribute("products", products);
			req.getRequestDispatcher("products.jsp").forward(req, resp);
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
