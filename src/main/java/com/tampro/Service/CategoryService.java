package com.tampro.Service;

import java.util.List;

import com.tampro.Model.CategoryDTO;
import com.tampro.Model.MadeByDTO;

public interface CategoryService {
    public CategoryDTO getCategoryById(int id);
	
	public List<CategoryDTO> getAllCategoryDTO();
	
	public void addCategoryDTO(CategoryDTO categoryDTO);
	
	public void deleteCategoryById(int id);
	
	public void updateCategory(CategoryDTO categoryDTO);

	public List<MadeByDTO> getAllMadeByDTOIdCategory(int idCategory);
}
