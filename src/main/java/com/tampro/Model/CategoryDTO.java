package com.tampro.Model;

import java.util.List;

public class CategoryDTO {
	private int id;
	private String name;
	private List<MadeByDTO> listMadeByDTO; // 1 danh muc dien thoai co the co nhieu hang san xuat
	
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
	public List<MadeByDTO> getListMadeByDTO() {
		return listMadeByDTO;
	}
	public void setListMadeByDTO(List<MadeByDTO> listMadeByDTO) {
		this.listMadeByDTO = listMadeByDTO;
	}

}
