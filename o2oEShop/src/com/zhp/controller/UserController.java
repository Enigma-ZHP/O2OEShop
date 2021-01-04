package com.zhp.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhp.model.GoodModel;
import com.zhp.model.UserModel;
import com.zhp.service.IUserService;
@Controller("UserController")
@RequestMapping("User")
public class UserController {
	@Resource(name="UserService")
	private IUserService userservice;
	@RequestMapping("/login")
	public void addUser(UserModel user,HttpServletResponse response) {
	
		System.out.println(user.getUname());
		userservice.addUser(user);
		int uid=user.getUid();
		System.out.println(uid);
		Cookie userid=new Cookie("userid",Integer.toString(uid));
		userid.setPath("/");
		userid.setHttpOnly(false);
		response.addCookie(userid);
		
		//return "redirect:../UserGoodExplore/GoodExplore.html";
	}
	@RequestMapping("/index")
	public String ShowIndex() {
		return "index";
	}
	@RequestMapping("updateuser")
	public String updateUser(UserModel user) {
		userservice.updateUser(user);
		return "redirect:../UserGoodExplore/GoodExplore.html";
	}
	@RequestMapping("updatemanageruser")
	public String updateManagerUser(UserModel user) {
		userservice.updateUser(user);
		return "redirect:../Manager/ManagerMain.html";
	}
	@RequestMapping("deleteUser")
	public String deleteUser(int id) {
		userservice.deleteUser(id);
		return "redirect:../Manager/ManagerMain.html";
	}
	@RequestMapping("userinfor")
	@ResponseBody
	public UserModel selectUserByid(int uid)throws Exception{
		return userservice.selectUserByid(uid);
	}
	@RequestMapping("/selectAllUser")
	@ResponseBody
	public List<UserModel> selectAllUser() throws Exception{
		
		return userservice.selectAllUser();
		
	}
	@RequestMapping(value="/inserttstPhoto", method=RequestMethod.POST)
	public String addUserWithPhoto(UserModel puser,MultipartFile photo) throws IOException {
		System.out.println("usercontroller");
		byte[] uphoto=photo.getBytes();
		puser.setUphoto(uphoto);
		if(puser.getUphoto()!=null) {
			System.out.println("photo alive");
		}else {
			System.out.println("photo lose");
		}
		userservice.addUserWithPhoto(puser);
		return "index";
	}
	@RequestMapping(value="userregister",produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public int RegisterUser(String id,String password)throws Exception{
		int uid=Integer.parseInt(id);
		System.out.println(uid);
		UserModel um=userservice.selectUserByid(uid);
		System.out.println(um.getUname());
		if(!(um.getUpassword().equals(password))) {
			System.out.println("ssss");
			return 0;
		}
		return um.getUid();
	}
	@RequestMapping("wish")
	public String addwish(int uid,int gid)throws Exception{
		UserModel um=new UserModel();
		um.setGid(gid);
		um.setUid(uid);
		userservice.addwish(um);
		return "UserGoodExplore/GoodExplore";
	}
	@RequestMapping(value="wishList",produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<GoodModel> selectwish(int uid)throws Exception{
		System.out.println(uid);
		
		return userservice.selectwish(uid);
	}
	@RequestMapping("wishdelete")
	public String deletewish(int id)throws Exception{
		userservice.deletewish(id);
		return "UserGoodExplore/wishList";
	}
}
