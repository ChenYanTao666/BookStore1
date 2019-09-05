package com.yuchen.service.impl;

import com.yuchen.bean.User;
import com.yuchen.dao.UserDao;
import com.yuchen.dao.impl.UserDaoImpl;
import com.yuchen.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();
	@Override
	public User login(User user) {
		return dao.checkUserNameAndPassWord(user);
	}

	@Override
	public boolean regist(User user) {
		if (dao.checkUserName(user)) {
			return false;
		}else {
			dao.saveUser(user);
			return true;
		}
	}

}
