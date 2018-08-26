package com.neutraining.service;

import java.sql.SQLException;
import java.util.List;

import com.neutraining.dao.CategoryDao;
import com.neutraining.model.Category;


public class CategoryService {

	public List<Category> getAllList() throws SQLException {
		CategoryDao cd = new CategoryDao();
		List<Category> categories = cd.getAllList();
		return categories;
	}


}
