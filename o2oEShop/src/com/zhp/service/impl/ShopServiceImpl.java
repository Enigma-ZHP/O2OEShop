package com.zhp.service.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.zhp.dao.IShopDao;
import com.zhp.model.GoodModel;
import com.zhp.model.ShopModel;
import com.zhp.service.IShopService;
@Service("ShopService")
public class ShopServiceImpl implements IShopService {
	@Resource(name="IShopDao")
	private IShopDao shopdao; 
	@Override
	public void insertShop(ShopModel sm) {
		// TODO Auto-generated method stub
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			SqlSession session=ssf.openSession();
			IShopDao sd=session.getMapper(IShopDao.class);
			sd.insertShop(sm);
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateShop(ShopModel sm) throws Exception{
		// TODO Auto-generated method stub
		shopdao.updateShop(sm);
	}

	

	@Override
	public void deleteShop(int id) throws Exception{
		// TODO Auto-generated method stub
		shopdao.deleteShop(id);
	}

	@Override
	public List<ShopModel> selectAllShop() throws Exception {
		// TODO Auto-generated method stub
		/*Reader reader;
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			SqlSession session=ssf.openSession();
			IShopDao sd=session.getMapper(IShopDao.class);
			List<ShopModel> lsm=sd.selectAllShop();
			session.commit();
			session.close();*/
		
		return shopdao.selectAllShop();
	}

	@Override
	public void insertShopGood(GoodModel gm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateShopGood(GoodModel gm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteShopGood(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShopModel> selectAllShopGood() throws Exception {
		// TODO Auto-generated method stub
		return shopdao.selectAllShop();
	}

	@Override
	public List<GoodModel> selectShopGoodById(int sid) throws Exception {
		// TODO Auto-generated method stub
		/*Reader reader;
		reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
		reader.close();
		SqlSession session=ssf.openSession();
		IShopDao sd=session.getMapper(IShopDao.class);
		ShopModel sm=sd.selectShopGoodById(sid);
		session.commit();
		session.close();*/
		
		
		return shopdao.selectShopGoodById(sid);
	}

	@Override
	public void insertShopAndCategory(ShopModel sm) throws Exception {
		// TODO Auto-generated method stub
		shopdao.insertShopAndCategory(sm);
	}

	@Override
	public void insertToshopcategory(ShopModel sm) throws Exception {
		// TODO Auto-generated method stub
		shopdao.insertToshopcategory(sm);
	}

	@Override
	public ShopModel selectShopById(int sid) throws Exception {
		// TODO Auto-generated method stub
		return shopdao.selectShopById(sid);
	}

	@Override
	public int selectMaxsid() throws Exception {
		// TODO Auto-generated method stub
		return shopdao.selectMaxsid();
	}

	@Override
	public ShopModel selectShopInfor(int sid) throws Exception {
		// TODO Auto-generated method stub
		return shopdao.selectShopInfor(sid);
	}




}
