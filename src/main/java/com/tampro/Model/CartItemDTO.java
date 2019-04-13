package com.tampro.Model;

public class CartItemDTO {
	private int id;
	private ProductDTO productDTO; // san pham
	private int quantity; //so luong cartitem
	private double totalPrice; //tong gia sau khi * quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
