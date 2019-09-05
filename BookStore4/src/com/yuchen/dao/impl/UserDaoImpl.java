package com.yuchen.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yuchen.Utils.JDBCUtils;
import com.yuchen.bean.User;
import com.yuchen.dao.BaseDao;
import com.yuchen.dao.UserDao;


public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User checkUserNameAndPassWord(User user) {
			String sql = "select id,username,password,email from users where username = ? and password = ?";
			User bean = getBean(sql, user.getUsername(),user.getPassword());			
			return bean;
	}

	@Override
	public boolean checkUserName(User user) {
		String sql = "select id,username,password,email from users where username = ?";
		User bean = getBean(sql, user.getUsername());	
		if (bean != null) {
			return true;
		}
		return false;
	}

	@Override
	public void saveUser(User user) {
		String sql = "insert into users(username,password,email) values(?,?,?)";
		update(sql, user.getUsername(),user.getPassword(),user.getEmail());
	}


}
