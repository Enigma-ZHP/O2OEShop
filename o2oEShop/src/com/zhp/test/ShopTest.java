package com.zhp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhp.model.GoodModel;
import com.zhp.model.ShopModel;
import com.zhp.service.IShopService;

public class ShopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("context.xml");
		IShopService iss=ac.getBean("ShopService", IShopService.class);
		ShopModel sm=new ShopModel();
		sm.setSname("服装店");
		sm.setSpassword("12345");

		try {
			iss.insertShopAndCategory(sm);
			int id=sm.getSid();
			sm.setSid(id);
			sm.setShopAndcategoryid(2);
			iss.insertToshopcategory(sm);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
