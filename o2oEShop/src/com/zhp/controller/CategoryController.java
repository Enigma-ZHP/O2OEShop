package com.zhp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhp.model.CategoryModel;
import com.zhp.model.ShopModel;
import com.zhp.service.ICategoryService;
@Controller("CategoryController")
@RequestMapping("Category")
public class CategoryController {
	@Resource(name="CategoryService")
	private ICategoryService categoryService;
	
	//@ResponseBody
	@RequestMapping(value="/shopcategory" ,method=RequestMethod.GET)//,produces={"application/json;charset=UTF-8"})
	public CategoryModel selectShopByCid(@RequestParam int cid) throws Exception{
		System.out.println(cid);
		CategoryModel cm=categoryService.selectShopCategory(cid);
		List<ShopModel> lsm=cm.getShopmodelList();
		for(ShopModel sm:lsm) {
			System.out.println(sm.getSname()+" ");
		}
		return cm;
	}
	public CategoryModel selectGoodByCid(int cid) {
		
		return null;
	}
}
