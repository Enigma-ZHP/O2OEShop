package com.zhp.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhp.factory.MyBatisFactory;
import com.zhp.model.GoodModel;
import com.zhp.model.ShopModel;
import com.zhp.model.UserModel;
import com.zhp.service.IGoodService;
import com.zhp.service.IShopService;
import com.zhp.service.IUserService;
import com.zhp.service.impl.GoodServiceImpl;
import com.zhp.service.impl.ShopServiceImpl;
import com.zhp.service.impl.UserServiceImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ShopModel sm=new ShopModel();
		//sm.setSname("Œ¢»ÌπŸ∑Ω∆ÏΩ¢µÍ");
		//sm.setSpassword("12345");
		//IShopService ss=new ShopServiceImpl();
		//ss.insertShop(sm);
		ApplicationContext ac=new ClassPathXmlApplicationContext("context.xml");
		IUserService ius=ac.getBean("UserService", IUserService.class);
		try {
			List<UserModel> lum=ius.selectAllUser();
			for(UserModel um:lum) {
				System.out.println(um.getUname());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
