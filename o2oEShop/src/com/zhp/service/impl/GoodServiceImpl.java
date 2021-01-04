package com.zhp.service.impl;

import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.zhp.dao.IGoodDao;
import com.zhp.model.GoodModel;
import com.zhp.service.IGoodService;
@Service("GoodService")
public class GoodServiceImpl implements IGoodService {
	@Resource(name="IGoodDao")
	private IGoodDao gooddao;
	@Override
	public void inserGood(GoodModel gm) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGood(GoodModel gm) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GoodModel> selectAllGood() throws Exception {
		// TODO Auto-generated method stub
		return gooddao.selectAllGood();
	}

	@Override
	public void deleteGood(int id) throws Exception {
		// TODO Auto-generated method stub
		gooddao.deleteGood(id);
	}

	

	@Override
	public void insertGoodWithPhoto(GoodModel gm) throws Exception {
		// TODO Auto-generated method stub
		gooddao.insertGoodWithPhoto(gm);
	}

	@Override
	public void insertGoodWithCategory(GoodModel gm) throws Exception {
		// TODO Auto-generated method stub
		gooddao.insertGoodWithCategory(gm);
	}

	@Override
	public GoodModel selectGoodById(int gid) throws Exception {
		// TODO Auto-generated method stub
		return gooddao.selectGoodById(gid);
	}

	@Override
	public List<GoodModel> selectGoodListBycid(int cid) throws Exception {
		// TODO Auto-generated method stub
		return gooddao.selectGoodListBycid(cid);
	}

	@Override
	public void updateGoodWhithPhoto(GoodModel gm) throws Exception {
		// TODO Auto-generated method stub
		gooddao.updateGoodWithPhoto(gm);
	}

	@Override
	public void updateGoodWithCategory(GoodModel gm) throws Exception {
		// TODO Auto-generated method stub
		gooddao.updateGoodWithCategory(gm);
	}

	@Override
	public List<GoodModel> selectGoodListBysid(int sid) throws Exception {
		// TODO Auto-generated method stub
		return gooddao.selectGoodListBysid(sid);
	}

}
