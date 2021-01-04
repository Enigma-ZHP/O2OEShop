package com.zhp.service;

import java.util.List;

import com.zhp.model.GoodModel;
import com.zhp.model.UserModel;

public interface IUserService {
	public void addUser(UserModel user);
	public void updateUser(UserModel user);
	public List<UserModel> selectAllUser() throws Exception;
	public void deleteUser(int id);
	public void addUserWithPhoto(UserModel puser);
	public UserModel selectUserByid(int uid)throws Exception;
	public void addwish(UserModel user)throws Exception;
	public List<GoodModel> selectwish(int uid)throws Exception;
	public void deletewish(int id)throws Exception;
}
