package com.zhp.dao;

import java.util.List;

import com.zhp.model.GoodModel;

public interface IGoodDao {
	public void inserGood(GoodModel gm) throws Exception;
	public void updateGood(GoodModel gm) throws Exception;
	public List<GoodModel> selectAllGood() throws Exception;
	public void deleteGood(int id) throws Exception;
	public GoodModel selectGoodById(int id)throws Exception;
	
	public void insertGoodWithPhoto(GoodModel gm)throws Exception;
	public void insertGoodWithCategory(GoodModel gm)throws Exception;
	public void updateGoodWithPhoto(GoodModel gm)throws Exception;
	public void updateGoodWithCategory(GoodModel gm)throws Exception;
	public List<GoodModel> selectGoodListBycid(int cid)throws Exception;
	public List<GoodModel> selectGoodListBysid(int sid)throws Exception;
}
