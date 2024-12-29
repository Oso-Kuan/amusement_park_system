package com.easy.dao;

import com.easy.bean.User;
import com.easy.util.Page;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUserDao {
	int getCount(@Param("user") User user);

	List<User> getUser(@Param("user") User user, @Param("page") Page page);

	User getUserByID(int id);

	int addUser(User user);

	int addList(List<User> user);

	int delUser(int id);

	int editUser(User user);

	int editUserItem(User user);

	int edit(@Param("id") int id, @Param("user") User user);

	List<User> getUserByUsername(String username);

	int userImg(User user);

}
