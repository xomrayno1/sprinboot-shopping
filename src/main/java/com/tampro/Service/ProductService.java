package com.tampro.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.tampro.Entity.Product;
import com.tampro.Model.ProductDTO;

public interface ProductService {
	
    public ProductDTO getProductById(int id);
	
	public List<ProductDTO> getAllProduct();
	
	public void addProductDTO(ProductDTO productdto);
	
	public void deleteProductDTO(int id);
	
	public void updateProductDTO(ProductDTO productdto);
	
	public List<ProductDTO> getProductDTOByIdCategory(int idCategory);   
	
	public List<ProductDTO> get8ProductByDateNews();
	
	public ProductDTO getProductDTOByUrl(String url);
	
	public int getQuantity(int idProduct);
	
	

}
