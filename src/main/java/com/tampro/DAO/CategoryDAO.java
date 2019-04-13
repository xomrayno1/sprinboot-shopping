package com.tampro.DAO;

import java.util.List;

import com.tampro.Entity.Category;
import com.tampro.Entity.MadeBy;

public interface CategoryDAO {
	
	public Category getCategoryById(int id);
	
	public List<Category> getAllCategory();
	
	public void addCategory(Category category);
	
	public void deleteCategory(Category category);
	
	public void updateCategory(Category category);
	
	
	public List<MadeBy> getAllMadeByIdCategory(int idCategory);

	

}
