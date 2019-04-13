package com.tampro.Model;

import java.util.List;

public class OrderDTO {
	private int id;
	private UserDTO userDTO; // nguoi dung order 
	private List<CartItemDTO> cartItemDTO ; // 1 order co rat nhieu san pham can order // tu do t
	private int status ; // da xu ly hay chua ..
	private String date;
	
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
	
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public List<CartItemDTO> getCartItemDTO() {
		return cartItemDTO;
	}
	public void setCartItemDTO(List<CartItemDTO> cartItemDTO) {
		this.cartItemDTO = cartItemDTO;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
