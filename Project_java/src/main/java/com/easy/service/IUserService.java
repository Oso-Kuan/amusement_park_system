package com.easy.service;

import java.util.List;

import com.easy.bean.User;
import com.easy.util.Page;

public interface IUserService {
	int getCount(User user);

	List<User> getUser(User user, Page page);

	User getUserByID(int id);

	int addUser(User user);

	int addList(List<User> user);

	int delUser(int id);

	int editUser(User user);

	String doLogin(User user);

	int userImg(User user);
}
