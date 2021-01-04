package com.zhp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhp.model.GoodModel;
import com.zhp.model.ShopModel;
import com.zhp.service.IShopService;
@Controller("ShopController")
@RequestMapping("Shop")
public class ShopController {
	@Resource(name="ShopService")
	private IShopService shopService;
	@ResponseBody
	@RequestMapping(value="/selectAllShop", produces= {"application/json;charset=UTF-8"})
	public List<ShopModel> selectAllShop() throws Exception {
		List<ShopModel> lsm=shopService.selectAllShop();
		for(ShopModel sm:lsm) {
			System.out.print(sm.getSname()+" ");
		}
		return lsm;
	}
	@ResponseBody
	@RequestMapping(value="/insertshop",produces={"application/json;charset=UTF-8"})
	public String insertShop(ShopModel sm) {
		shopService.insertShop(sm);
		return "Shop/list-product.html";
	}
	
	@RequestMapping(value="/updateshop")
	public String updateShop(ShopModel sm) throws Exception {
		shopService.updateShop(sm);
		return "redirect:../Good/main.html";
	}
	@RequestMapping("updatemanagershop")
	public String updateManagerShop(ShopModel sm)throws Exception{
		shopService.updateShop(sm);
		return "redirect:../Manager/ManagerMain.html";
	}
	
	@RequestMapping(value="/deleteshop")
	public String deleteShop(int id) throws Exception {
		shopService.deleteShop(id);
		return "redirect:../Manager/ManagerMain.html";
	}

	@RequestMapping(value="/shopid/{sid}", produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<GoodModel> selecShopGoodById(@PathVariable("sid") int sid) throws Exception{
		List<GoodModel> lgm=shopService.selectShopGoodById(sid);
		
		return lgm;
	}
	@RequestMapping(value="/shoplogin")
	public void CreateShopWithCategory(ShopModel sm,int cid,HttpServletResponse response) throws Exception {
		
		shopService.insertShopAndCategory(sm);
		int sid=sm.getSid();
		sm.setSid(sid);
		sm.setShopAndcategoryid(cid);
		shopService.insertToshopcategory(sm);
		Cookie shopid=new Cookie("shopid",Integer.toString(sid));
		shopid.setPath("/");
		shopid.setHttpOnly(false);
		response.addCookie(shopid);
		System.out.println("sid:"+sid);
		//return "redirect:../Good/main.html";//重定向
	}
	
	@RequestMapping(value = "getCookie")   
	@ResponseBody
	public String getCookie(@CookieValue("shopid") String shopid){        
		      
		System.out.println("shopid: " + shopid);   
		return shopid; 
	}
	@RequestMapping(value="shopregister",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public int RegisterShop(String id,String password) throws Exception {
		
		int sid=Integer.parseInt(id);
		ShopModel sm=shopService.selectShopById(sid);
		System.out.println(sm.getSname());
		if(!(sm.getSpassword().equals(password))) {
			return 0;
		}
		return sm.getSid();
	}
	@RequestMapping("shopinfor")
	@ResponseBody
	public ShopModel selectShopInfor(int sid)throws Exception{
		System.out.println("hlleo");
		return shopService.selectShopInfor(sid);
	}
		
}
