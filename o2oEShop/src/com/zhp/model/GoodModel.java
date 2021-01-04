package com.zhp.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias("good")
public class GoodModel {
	private int gid;
	private int sid;
	private String gname;
	private String gdate;
	private int gprice;
	private int cid;
	private int id;//购物车主键用于删除关联
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private byte[] gphoto;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	public byte[] getGphoto() {
		return gphoto;
	}
	public void setGphoto(byte[] gphoto) {
		this.gphoto = gphoto;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGdate() {
		return gdate;
	}
	public void setGdate(String gdate) {
		this.gdate = gdate;
	}
	
}
