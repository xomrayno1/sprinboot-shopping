package com.tampro.DAO;

import com.tampro.Entity.Address;

public interface AddressDAO {
	
	public void deleteAddress(Address address);
	
	public void updateAddress(Address address);
	
	public Address getAddressById(int id);
	
	public void addAddress(Address address);


}
