package com.zhp.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("shop")
public class ShopModel {
	private int sid;
	private String sname;
	private String spassword;
	private List<GoodModel> goodmodel;
	private int shopAndcategoryid;
	public int getShopAndcategoryid() {
		return shopAndcategoryid;
	}
	public void setShopAndcategoryid(int shopAndcategoryid) {
		this.shopAndcategoryid = shopAndcategoryid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public List<GoodModel> getGoodmodel() {
		return goodmodel;
	}
	public void setGoodmodel(List<GoodModel> goodmodel) {
		this.goodmodel = goodmodel;
	}
}
