package service;

import java.io.File;
import java.util.List;
import repository.CategoryDAO;
import repository.CategoryDAOImpl;
import model.Category;

public class CategoryServiceImpl implements CategoryService {
	CategoryDAO categoryDao = new CategoryDAOImpl();

	@Override
	public void insert(Category category) {
		categoryDao.insert(category);

	}

	@Override
	public void edit(Category newCategory) {
		Category oldCategory = categoryDao.get(newCategory.getCateid());
		oldCategory.setCatename(newCategory.getCatename());
		if (newCategory.getIcon() != null) {
			// XOA ANH CU DI
			String fileName = oldCategory.getIcon();
			File file = new File(util.Constant.UPLOAD_DIR + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldCategory.setIcon(newCategory.getIcon());
		}
		categoryDao.edit(oldCategory);
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public Category get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public Category get(String name) {
		return categoryDao.get(name);
	}

	@Override
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public List<Category> search(String catename) {
		return categoryDao.search(catename);
	}
}
