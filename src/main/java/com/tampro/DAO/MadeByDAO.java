package com.tampro.DAO;

import java.util.List;

import com.tampro.Entity.MadeBy;

public interface MadeByDAO {
	
	public void deleteById(MadeBy made);
	
	public void updateMadeby(MadeBy madeby);
	
	public MadeBy getMadeById(int id);
	
	public List<MadeBy> getMadeByIdCategory(int idCategory);
	
	public void AddMadeby(MadeBy madeby);
	
	public List<MadeBy> getAllMadeBy();	

}
