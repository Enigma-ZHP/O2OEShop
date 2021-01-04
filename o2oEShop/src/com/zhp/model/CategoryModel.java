package com.zhp.model;

import java.util.List;

import org.apache.ibatis.type.Alias;
@Alias("category")
public class CategoryModel {
	private int cid;
	private String cname;
	private List<GoodModel> goodmodelList;//与collection中property对应
	private List<ShopModel> shopmodelList;
	public List<GoodModel> getGoodmodelList() {
		return goodmodelList;
	}
	public void setGoodmodelList(List<GoodModel> goodmodelList) {
		this.goodmodelList = goodmodelList;
	}
	public List<ShopModel> getShopmodelList() {
		return shopmodelList;
	}
	public void setShopmodelList(List<ShopModel> shopmodelList) {
		this.shopmodelList = shopmodelList;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
