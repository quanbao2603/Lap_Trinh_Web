package service;

import java.util.List;

import dao.CategoryDAOImpl;
import dao.interfaces.CategoryDAO;
import entity.Category;
import service.interfaces.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	CategoryDAO cateDao = new CategoryDAOImpl();
	
	@Override
	public List<Category> findAll() {
		return cateDao.findAll();
	}

	@Override
	public void create(Category category) {
		cateDao.create(category);
	}

	@Override
	public void update(Category category) {
		cateDao.update(category);
	}

	@Override
	public void delete(int id) {
		cateDao.delete(id);
	}

	@Override
	public Category findById(int id){ 
		return cateDao.findById(id);
	}

	@Override
	public List<Category> findByRole(int role) {
		 return cateDao.findByRole(role);
	}
}
