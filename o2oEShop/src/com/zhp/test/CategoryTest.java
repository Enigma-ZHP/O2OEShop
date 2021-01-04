package com.zhp.test;

import java.util.List;

import com.zhp.model.CategoryModel;
import com.zhp.model.ShopModel;
import com.zhp.service.ICategoryService;
import com.zhp.service.impl.CategoryServiceImpl;

public class CategoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICategoryService ics=new CategoryServiceImpl();
		try {
			List<ShopModel> cm=ics.selectShopBycid(1);
			for(ShopModel sm:cm) {
				System.out.println(sm.getSid()+" "+sm.getSname());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
