package com.yuchen.dao;

import com.yuchen.bean.User;

public interface UserDao {
	/**
	 * 验证用户登录是否成功
	 * @param user
	 * @return 是否登录成
	 */
	public User checkUserNameAndPassWord(User user);
	/**
	 * 验证用户名是否存在
	 * @param user
	 * @return 是否有这个用户
	 */
	public boolean checkUserName(User user);
	/**
	 * 保存用户
	 * @param user
	 */
	public void saveUser(User user);

}
