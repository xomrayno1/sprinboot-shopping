package com.tampro.Service;

import java.util.List;

import com.tampro.Model.MadeByDTO;

public interface MadeByService {
	
    public void deleteById(int id);
	
	public void updateMadeByDTO(MadeByDTO madebydto);
	
	public MadeByDTO getMadeByDTOId(int id);
	
	public List<MadeByDTO> getMadeByDTOIdCategory(int idCategory);

	
	public void AddMadeby(MadeByDTO madebydto);
	
	public List<MadeByDTO> getAllMade( );
}
