package com.tampro.Model;

import org.hibernate.validator.constraints.Length;

public class UserDTO {
	private int id;
	@Length(min = 4,max = 12)
	private String userName; // tai khoan
	@Length(min = 4,max = 12)
	private String passWord;// mat khau 
	
	private String email; //email 

	private String phone; // dien thoai

	private String firstName; // ten dau 
	
	private String lastName;// ten cuoi 
	private String role; 
	
	
	
	public UserDTO() {
		super();
	}
	public UserDTO(String userName, String passWord, String email, String phone, String firstName, String lastName,
			String role) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	

}
