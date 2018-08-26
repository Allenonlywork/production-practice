package com.neutraining.service;

import java.sql.SQLException;
import java.util.List;

import com.neutraining.dao.ProductDao;
import com.neutraining.model.Product;

public class ProductService {

	public List<Product> getAllList() throws SQLException{
		//调用dao查询所有的商品信息
		ProductDao pd = new ProductDao();
		List<Product> products = pd.getAllList();
		return products;
	}

	public Product getProductById(String pid) throws SQLException {
		ProductDao pd = new ProductDao();
		Product product = pd.getProductById(pid);
		return product;
	}

}
