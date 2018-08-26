package com.neutraining.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.neutraining.model.Product;
import com.neutraining.utils.DataSourceUtils;

public class ProductDao {
	public List<Product> getAllList() throws SQLException{
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select *,shop_price shopPrice,market_price marketPrice from product";
		
		List<Product> products = qr.query(sql, new BeanListHandler<>(Product.class));
		return products;
	}

	public Product getProductById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select *,shop_price shopPrice,market_price marketPrice from product where pid = ?";
		Product product = qr.query(sql, new BeanHandler<>(Product.class),pid);
		return product;
	}
}
