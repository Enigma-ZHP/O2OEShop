package com.zhp.dao;

import java.util.List;

import com.zhp.model.CategoryModel;
import com.zhp.model.ShopModel;

public interface ICategoryDao {
	public void insertCategory(CategoryModel cm) throws Exception;
	public void updateCategory(CategoryModel cm) throws Exception;
	public List<CategoryModel> selectAllCategory() throws Exception;
	public void deleteCategory(int id) throws Exception;
	public CategoryModel selectShopCategory(int sid)throws Exception;
	public CategoryModel selectGoodCategory(int sid)throws Exception;
	
	public List<ShopModel> selectShopBycid(int cid)throws Exception;
}
