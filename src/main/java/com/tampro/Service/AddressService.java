package com.tampro.Service;

import com.tampro.Model.AddressDTO;

public interface AddressService {
	
    public void deleteAddressDTO(int id);
	
	public void updateAddressDTO(AddressDTO addressdto);
	
	public AddressDTO getAddressDTOById(int id);
	
	public void addAddressDTO(AddressDTO addressdto);

}
