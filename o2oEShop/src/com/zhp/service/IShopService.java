package com.zhp.service;

import java.util.List;

import com.zhp.model.GoodModel;
import com.zhp.model.ShopModel;

public interface IShopService {
	public void insertShop(ShopModel sm);
	public void updateShop(ShopModel sm) throws Exception;
	public List<ShopModel> selectAllShop() throws Exception;
	public void deleteShop(int id)throws Exception;
	//
	public void insertShopGood(GoodModel gm);
	public void updateShopGood(GoodModel gm);
	public void deleteShopGood(int id);
	//
	public List<ShopModel> selectAllShopGood() throws Exception;
	public List<GoodModel> selectShopGoodById(int sid)throws Exception;
	public void insertShopAndCategory(ShopModel sm)throws Exception;
	public void insertToshopcategory(ShopModel sm)throws Exception;
	public ShopModel selectShopById(int sid)throws Exception;
	public ShopModel selectShopInfor(int sid)throws Exception;
	public int selectMaxsid()throws Exception;
}
