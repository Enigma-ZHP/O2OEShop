package com.zhp.service.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.zhp.dao.IUserDao;
import com.zhp.model.GoodModel;
import com.zhp.model.UserModel;
import com.zhp.service.IUserService;
@Service("UserService")
public class UserServiceImpl implements IUserService{
	@Resource(name="IUserDao")
	private IUserDao userdao;
	@Override
	public void addUser(UserModel user) {
		// TODO Auto-generated method stub
		/*Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			SqlSession session=ssf.openSession();
			IUserDao ud=session.getMapper(IUserDao.class);
			ud.addUser(user);
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.userdao.addUser(user);
		
	}

	@Override
	public void updateUser(UserModel user) {
		// TODO Auto-generated method stub
		/*Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			SqlSession session=ssf.openSession();
			IUserDao ud=session.getMapper(IUserDao.class);
			ud.updateUser(user);
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.userdao.updateUser(user);
	}

	@Override
	public List<UserModel> selectAllUser() throws Exception {
		// TODO Auto-generated method stub
		/*Reader reader;
		
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			SqlSession session=ssf.openSession();
			IUserDao ud=session.getMapper(IUserDao.class);
			List<UserModel> lum=ud.selectAllUser();
			session.commit();
			session.close();
			*/
		List<UserModel> lum=this.userdao.selectAllUser();
		
		return lum;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		/*Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			SqlSession session=ssf.openSession();
			IUserDao ud=session.getMapper(IUserDao.class);
			ud.deleteUser(id);
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.userdao.deleteUser(id);
	}

	@Override
	public void addUserWithPhoto(UserModel puser) {
		// TODO Auto-generated method stub
		/*Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			SqlSession session=ssf.openSession();
			IUserDao ud=session.getMapper(IUserDao.class);
			ud.addUserWithPhoto(puser);
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.userdao.addUserWithPhoto(puser);
	}

	@Override
	public UserModel selectUserByid(int uid) throws Exception {
		// TODO Auto-generated method stub

		return userdao.selectUserByid(uid);
	}

	@Override
	public void addwish(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		userdao.addwish(user);
	}

	@Override
	public List<GoodModel> selectwish(int uid) throws Exception {
		// TODO Auto-generated method stub
		return userdao.selectwish(uid);
	}

	@Override
	public void deletewish(int id) throws Exception {
		// TODO Auto-generated method stub
		userdao.deletewish(id);
		
	}

	





}
