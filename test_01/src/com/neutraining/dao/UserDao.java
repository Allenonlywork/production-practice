package com.neutraining.dao;

import java.sql.SQLException;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neutraining.model.User;
import com.neutraining.utils.DataSourceUtils;
import com.neutraining.utils.UUIDUtils;

public class UserDao {
	/**
	 * getByUserName()
	 * save()
	 * @throws SQLException 
	 */
	public int getByUserName(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) count from user where username = ?";
		int count = ((Long)qr.query(sql, new ScalarHandler(), username)).intValue();
		return count;
		
	}
	
	
	public void save(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user (uid,username,realname,password,gender,phone,email) values (?,?,?,?,?,?,?)";
		qr.update(sql,UUIDUtils.getId(), user.getUsername(),user.getRealname(),user.getPassword(),user.getGender(),user.getPhone(),user.getEmail());
		
	}
	public User getUserByUnAndPwd(String username,String password) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		User user = qr.query(sql, new BeanHandler<>(User.class),username,password);
		return user;
		
	}
}
