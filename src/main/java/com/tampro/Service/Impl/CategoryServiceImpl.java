package com.tampro.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.CategoryDAO;
import com.tampro.Entity.Category;
import com.tampro.Entity.MadeBy;
import com.tampro.Model.CategoryDTO;
import com.tampro.Model.MadeByDTO;
import com.tampro.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	CategoryService categorySer;

	@Override
	public CategoryDTO getCategoryById(int id) {
		Category category = categoryDAO.getCategoryById(id);
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		
		// TODO Auto-generated method stub
		return categoryDTO;
	}

	@Override
	public List<CategoryDTO> getAllCategoryDTO() {
		// TODO Auto-generated method stub
		List<Category> list = categoryDAO.getAllCategory();
		List<CategoryDTO> listDTO = new ArrayList<CategoryDTO>();
		for(Category cate  : list) {
			CategoryDTO cateDTO = new CategoryDTO();
			List<MadeByDTO> listMade  = categorySer.getAllMadeByDTOIdCategory(cate.getId());
			cateDTO.setListMadeByDTO(listMade);
			cateDTO.setId(cate.getId());
			cateDTO.setName(cate.getName());			
			listDTO.add(cateDTO);
			
		}
		return listDTO;
	}

	@Override
	public void addCategoryDTO(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		Category category = new Category();
        //category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		categoryDAO.addCategory(category);
	}

	@Override
	public void deleteCategoryById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		categoryDAO.addCategory(category);
		
	}

	@Override
	public List<MadeByDTO> getAllMadeByDTOIdCategory(int idCategory) {
		List<MadeBy> listMadeby = categoryDAO.getAllMadeByIdCategory(idCategory);
		List<MadeByDTO> listmadebyDTO = new ArrayList<MadeByDTO>();
		for(MadeBy made : listMadeby) {
			MadeByDTO madeDTO = new MadeByDTO();
			madeDTO.setId(made.getId());
			madeDTO.setName(made.getName());
			listmadebyDTO.add(madeDTO);
		}
		
		return listmadebyDTO;
	}
	

}
