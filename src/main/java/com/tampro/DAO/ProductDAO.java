package com.tampro.DAO;

import java.util.List;

import com.tampro.Entity.Product;

public interface ProductDAO {
    public Product getProductById(int id);
	
	public List<Product> getAllProduct();
	
	public void addProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public void updateProduct(Product product);
	
	public List<Product> getProductByIdCategory(int idCategory);
	
	public List<Product> get8ProductByDateNews();
	
	 public Product getProductByUrl(String url);

	 public int getQuantity(int idProduct);
}
