package com.tampro.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.MadeByDAO;
import com.tampro.Entity.MadeBy;
import com.tampro.Model.MadeByDTO;
import com.tampro.Service.MadeByService;

@Service
public class MadeByServiceImpl implements MadeByService{
	
	@Autowired
	MadeByDAO made;

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		MadeBy madeby = made.getMadeById(id);
		made.deleteById(madeby);
	}

	@Override
	public void updateMadeByDTO(MadeByDTO madebydto) {
		// TODO Auto-generated method stub
		MadeBy madeby = new MadeBy();
		madeby.setId(madebydto.getId());
		madeby.setName(madebydto.getName());
		made.updateMadeby(madeby);
	}

	@Override
	public MadeByDTO getMadeByDTOId(int id) {
		MadeBy madeby = made.getMadeById(id);
		MadeByDTO madebydto = new MadeByDTO();
		madebydto.setId(madeby.getId());
		madebydto.setName(madeby.getName());
		return madebydto;
	}

	@Override
	public List<MadeByDTO> getMadeByDTOIdCategory(int idCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddMadeby(MadeByDTO madebydto) {
		MadeBy madeby = new MadeBy();
		//madeby.setId(madebydto.getId());
		madeby.setName(madebydto.getName());
		made.AddMadeby(madeby);
		
	}

	@Override
	public List<MadeByDTO> getAllMade() {
		List<MadeBy> listMadeBy = made.getAllMadeBy();
		List<MadeByDTO> listmadeByDTO = new ArrayList<MadeByDTO>();
		for(MadeBy made : listMadeBy) {
			MadeByDTO  madedto = new MadeByDTO();
			madedto.setId(made.getId());
			madedto.setName(made.getName());
			listmadeByDTO.add(madedto);
		}
		return listmadeByDTO;
	}

}
