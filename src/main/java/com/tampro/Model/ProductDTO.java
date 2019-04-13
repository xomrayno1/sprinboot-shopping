package com.tampro.Model;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
	private int id;
	private String name; //ten san pham
	private int quantity; // so luong san pham trong kho
	private String price; //gia san pham
	private MadeByDTO  madeByDTO; // nha san xuat
	private CategoryDTO categoryDTO; //danh muc
	private String describe; //  mieu ta 
	private MultipartFile multipartFile; //upload hinh anh 
	private String date;
	private String url;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		
		
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public MadeByDTO getMadeByDTO() {
		return madeByDTO;
	}
	public void setMadeByDTO(MadeByDTO madeByDTO) {
		this.madeByDTO = madeByDTO;
	}
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public MultipartFile getMultipartFile() {
		
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	
	

}
