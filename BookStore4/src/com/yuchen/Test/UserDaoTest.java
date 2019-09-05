package com.yuchen.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yuchen.bean.User;
import com.yuchen.dao.UserDao;
import com.yuchen.dao.impl.UserDaoImpl;

public class UserDaoTest {

	
	UserDao dao = new UserDaoImpl();
	@Test
	public void testCheckUserNameAndPassWord() {
		User user = dao.checkUserNameAndPassWord(new User(1, "yuchen", "123456", ""));
		System.out.println(user);
	}

	@Test
	public void testCheckUserName() {
		boolean res = dao.checkUserName(new User(1, "yuchen", "123456", ""));
		System.out.println(res);
	}

	@Test
	public void testSaveUser() {
		 dao.saveUser(new User(1, "yuchen", "123456", "123@qq.com"));
	
	}

}
