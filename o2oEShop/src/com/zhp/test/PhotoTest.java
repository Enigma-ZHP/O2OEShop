package com.zhp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.zhp.model.UserModel;
import com.zhp.service.IUserService;
import com.zhp.service.impl.UserServiceImpl;

public class PhotoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("C:\\Users\\zhang\\Desktop\\text.jpg");
		try {
			FileInputStream fis=new FileInputStream(f);
			byte[] bytes=new byte[(int) f.length()];
			try {
				fis.read(bytes);
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserModel user=new UserModel();
			//user.setUphoto(bytes);
			IUserService ius=new UserServiceImpl();
			ius.addUserWithPhoto(user);
			System.out.println("photo insert success");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
