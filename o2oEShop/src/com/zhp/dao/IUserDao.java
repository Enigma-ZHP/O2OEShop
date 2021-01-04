package com.zhp.dao;

import java.util.List;

import com.zhp.model.GoodModel;
import com.zhp.model.UserModel;

public interface IUserDao {
	public void addUser(UserModel user);
	public void updateUser(UserModel user);
	public List<UserModel> selectAllUser();
	public void deleteUser(int id);
	public void addUserWithPhoto(UserModel puser);
	public UserModel selectUserByid(int uid);
	public void addwish(UserModel user);
	public List<GoodModel> selectwish(int uid);
	public void deletewish(int id);
}
