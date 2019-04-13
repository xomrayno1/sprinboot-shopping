package com.tampro.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.DAO.AddressDAO;
import com.tampro.Entity.Address;
import com.tampro.Model.AddressDTO;
import com.tampro.Service.AddressService;

@Service
public class AddressServiceImpl  implements AddressService{

	@Autowired
	AddressDAO addressDAO;
	
	@Override
	public void deleteAddressDTO(int id) {
		// TODO Auto-generated method stub
	   Address address = addressDAO.getAddressById(id);
	   addressDAO.deleteAddress(address);
	}

	@Override
	public void updateAddressDTO(AddressDTO addressdto) {
		// TODO Auto-generated method stub
	   Address address = new Address();
	   address.setId(addressdto.getId());
	   address.setDetail(addressdto.getDetail());
	   address.setDistrict(addressdto.getDistrict());
	   address.setProvincial(addressdto.getProvincial());
	   address.setStreet(addressdto.getStreet());	   
	   addressDAO.updateAddress(address);
	}

	@Override
	public AddressDTO getAddressDTOById(int id) {
		// TODO Auto-generated method stub
        Address address = addressDAO.getAddressById(id);
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setDetail(address.getDetail());
        addressDTO.setDistrict(address.getDistrict());
        addressDTO.setId(address.getId());
        addressDTO.setProvincial(address.getProvincial());
        addressDTO.setStreet(address.getStreet());
		return addressDTO;
	}

	@Override
	public void addAddressDTO(AddressDTO addressdto) {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setDetail(addressdto.getDetail());
		address.setDistrict(addressdto.getDistrict());
		address.setStreet(addressdto.getStreet());
		address.setProvincial(addressdto.getProvincial());
		//addressDAO.addAddress(address);
		 addressDAO.addAddress(address);
	}

}
