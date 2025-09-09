package dao.interfaces;

import java.util.List;

import entity.Category;

public interface CategoryDAO {
	List<Category> findAll();
	void create(Category category);
	void update(Category category);
	void delete(int id);
	Category findById(int id);
	List<Category> findByRole(int role);
}