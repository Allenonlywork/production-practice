package com.neutraining.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.neutraining.model.Category;
import com.neutraining.utils.DataSourceUtils;



public class CategoryDao {

	public List<Category> getAllList() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		
		List<Category> categories = qr.query(sql, new BeanListHandler<>(Category.class));
		return categories;
	}

}
