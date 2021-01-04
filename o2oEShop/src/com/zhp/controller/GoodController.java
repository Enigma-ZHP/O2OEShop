package com.zhp.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhp.model.GoodModel;
import com.zhp.service.IGoodService;

@Controller("GoodController")
@RequestMapping("Good")
public class GoodController {
	@Resource(name="GoodService")
	private IGoodService goodservice;
	@RequestMapping(value="/addgood",method=RequestMethod.POST)
	public String insertGoodWithPhoto(GoodModel gm,@RequestParam(value="photo") MultipartFile photo,int cid,@CookieValue("shopid")String sid) throws Exception {
		System.out.println(sid);
		int shopid=Integer.parseInt(sid);
		byte[] gph=photo.getBytes();
		gm.setGphoto(gph);
		gm.setSid(shopid);
		goodservice.insertGoodWithPhoto(gm);
		int id=gm.getGid();
		gm.setGid(id);
		gm.setCid(cid);
		System.out.println(gm.getCid()+"  "+gm.getGid());
		goodservice.insertGoodWithCategory(gm);
		return "/Good/main";
	}
	@RequestMapping(value="/managerAddgood",method=RequestMethod.POST)
	public String ManagerinsertGoodWithPhoto(GoodModel gm,@RequestParam(value="photo") MultipartFile photo,int cid,String sid) throws Exception{
		int shopid=Integer.parseInt(sid);
		byte[] gph=photo.getBytes();
		gm.setGphoto(gph);
		gm.setSid(shopid);
		goodservice.insertGoodWithPhoto(gm);
		int id=gm.getGid();
		gm.setGid(id);
		gm.setCid(cid);
		System.out.println(gm.getCid()+"  "+gm.getGid());
		goodservice.insertGoodWithCategory(gm);
		return "redirect:../Manager/ManagerMain.html";
	}
	@RequestMapping("/updategood")
	public String updateGoodWithPhoto(GoodModel gm,@RequestParam(value="photo") MultipartFile photo,int cid,@CookieValue("shopid")String sid) throws Exception {
		int shopid=Integer.parseInt(sid);
		byte[] gph=photo.getBytes();
		gm.setSid(shopid);
		gm.setGphoto(gph);
		int id=gm.getGid();
		goodservice.updateGoodWhithPhoto(gm);
		
		System.out.println(id);
		gm.setGid(id);
		gm.setCid(cid);
		goodservice.updateGoodWithCategory(gm);
		return "/Good/main";
	}
	@RequestMapping(value="managerUpdategood",method=RequestMethod.POST)
	public String ManagerupdateGoodWithPhoto(GoodModel gm,@RequestParam(value="photo") MultipartFile photo,int cid,String sid)throws Exception{
		int shopid=Integer.parseInt(sid);
		byte[] gph=photo.getBytes();
		gm.setSid(shopid);
		gm.setGphoto(gph);
		int id=gm.getGid();
		goodservice.updateGoodWhithPhoto(gm);
		
		System.out.println(id);
		gm.setGid(id);
		gm.setCid(cid);
		goodservice.updateGoodWithCategory(gm);
		return "redirect:../Manager/ManagerMain.html";
	}
	@RequestMapping("/Managerdeletegood")
	public String ManagerdeleteGood(int id)throws Exception{
		goodservice.deleteGood(id);
		return "redirect:../Manager/ManagerMain.html";
	}
	@RequestMapping("/deletegood")
	public String deleteGood(@RequestParam("id")int id) throws Exception {
		goodservice.deleteGood(id);
		return "/Good/main";
	}
	@ResponseBody
	@RequestMapping(value="/goodlist",produces= {"application/json;charset=UTF-8"})
	public List<GoodModel> selectAllGood() throws Exception {
		
		return goodservice.selectAllGood();
		
	}
	@RequestMapping("/getPhoto")
	public void getPhoto(int id,HttpServletResponse response) throws Exception {
		GoodModel gm=goodservice.selectGoodById(id);
		response.setContentType("image/jpeg");
		OutputStream out=response.getOutputStream();
		out.write(gm.getGphoto());
		out.flush();
		out.close();
	}
	@RequestMapping("/goodbyid")
	@ResponseBody
	public GoodModel selectGoodById(int gid) throws Exception {
		return goodservice.selectGoodById(gid);
		
	}
	@RequestMapping(value="/goodlistbycid")
	@ResponseBody
	public List<GoodModel> selectGoodListBycid(@RequestParam("id")int cid)throws Exception {
		
		return goodservice.selectGoodListBycid(cid);
	}
	@RequestMapping("goodlistbysid")
	@ResponseBody
	public List<GoodModel> selectGoodListBysid(int sid)throws Exception{
		
		return goodservice.selectGoodListBysid(sid);
	}
}
