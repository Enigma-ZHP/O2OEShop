package com.zhp.service.impl;

import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.zhp.dao.ICategoryDao;
import com.zhp.model.CategoryModel;
import com.zhp.model.ShopModel;
import com.zhp.service.ICategoryService;
@Service("CategoryService")
public class CategoryServiceImpl implements ICategoryService {
	@Resource(name="ICategoryDao")
	private ICategoryDao categorydao;
	@Override
	public void insertCategory(CategoryModel cm) throws Exception{
		// TODO Auto-generated method stub
		/*Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
		reader.close();
		SqlSession session=ssf.openSession();
		ICategoryDao icd=session.getMapper(ICategoryDao.class);
		icd.insertCategory(cm);
		session.commit();
		session.close();*/
		categorydao.insertCategory(cm);
	}

	@Override
	public void updateCategory(CategoryModel cm) throws Exception{
		// TODO Auto-generated method stub
		/*Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
		reader.close();
		SqlSession session=ssf.openSession();
		ICategoryDao icd=session.getMapper(ICategoryDao.class);
		icd.updateCategory(cm);
		session.commit();
		session.close();*/
		categorydao.updateCategory(cm);
	}

	@Override
	public List<CategoryModel> selectAllCategory() throws Exception {
		// TODO Auto-generated method stub
		/*Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
		reader.close();
		SqlSession session=ssf.openSession();
		ICategoryDao icd=session.getMapper(ICategoryDao.class);
		List<CategoryModel> lcm=icd.selectAllCategory();
		session.commit();
		session.close();*/
		return categorydao.selectAllCategory();
	}

	@Override
	public void deleteCategory(int id) throws Exception{
		// TODO Auto-generated method stub
		/*Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(reader);
		reader.close();
		SqlSession session=ssf.openSession();
		ICategoryDao icd=session.getMapper(ICategoryDao.class);
		icd.deleteCategory(id);
		session.commit();
		session.close();*/
		categorydao.deleteCategory(id);
	}

	@Override
	public CategoryModel selectShopCategory(int cid) throws Exception {
		// TODO Auto-generated method stub
		
		return categorydao.selectShopCategory(cid);
	}

	@Override
	public CategoryModel selectGoodCategory(int cid) throws Exception {
		// TODO Auto-generated method stub
		return categorydao.selectShopCategory(cid);
	}

	@Override
	public List<ShopModel> selectShopBycid(int cid) throws Exception {
		// TODO Auto-generated method stub
		return categorydao.selectShopBycid(cid);
	}

	

}
