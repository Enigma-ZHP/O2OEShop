package com.zhp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhp.model.GoodModel;
import com.zhp.service.IGoodService;

public class GoodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("context.xml");
		//IShopService iss=ac.getBean("ShopService", IShopService.class);
		IGoodService igs=ac.getBean("GoodService", IGoodService.class);
		GoodModel gm=new GoodModel();
		File f=new File("C:\\Users\\zhang\\Desktop\\text.jpg");
		try {
			FileInputStream fis=new FileInputStream(f);
			byte[] bytes=new byte[(int) f.length()];
			fis.read(bytes);
			fis.close();
			gm.setGphoto(bytes);
			gm.setGname("aa");
			gm.setGdate("2020-10-10");
			gm.setGprice(1000);
			igs.insertGoodWithPhoto(gm);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}
}
