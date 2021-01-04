package com.zhp.model;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("user")
public class UserModel {
	private int uid;
	private int uage;
	private String uname;
	private String upassword;
	private int gid;
	private int id;//购物车主键
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private byte[] uphoto;
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public byte[] getUphoto() {
		return uphoto;
	}
	public void setUphoto(byte[] uphoto) {
		this.uphoto = uphoto;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
}
	
