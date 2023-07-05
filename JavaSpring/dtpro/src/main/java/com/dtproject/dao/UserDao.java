package com.dtproject.dao;

import com.dtproject.model.User;

public interface UserDao {

	void saveUser(User user);

	User findUserByname(String userName);

}
