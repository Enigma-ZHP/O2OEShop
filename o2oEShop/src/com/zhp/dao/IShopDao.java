package com.zhp.dao;

import java.util.List;

import com.zhp.model.GoodModel;
import com.zhp.model.ShopModel;

public interface IShopDao {
	public void insertShop(ShopModel sm);
	public void updateShop(ShopModel sm);
	public List<ShopModel> selectAllShop();
	public void deleteShop(int id);
	//
	public void insertShopGood(GoodModel gm);
	public void updateShopGood(GoodModel gm);
	public void deleteShopGood(int id);
	public List<ShopModel> selectAllShopGood() throws Exception;
	public List<GoodModel> selectShopGoodById(int sid)throws Exception;
	public void insertShopAndCategory(ShopModel sm)throws Exception;
	public void insertToshopcategory(ShopModel sm)throws Exception;
	public ShopModel selectShopById(int sid)throws Exception;
	public ShopModel selectShopInfor(int sid)throws Exception;
	public int selectMaxsid()throws Exception;
}
