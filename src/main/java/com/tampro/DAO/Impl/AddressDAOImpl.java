package com.tampro.DAO.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.DAO.AddressDAO;
import com.tampro.Entity.Address;

@Repository
@Transactional
public class AddressDAOImpl implements AddressDAO{

	@PersistenceContext
	EntityManager entity;
	
	@Override
	public void deleteAddress(Address address) {
		// TODO Auto-generated method stub
		entity.remove(address);
	}

	@Override
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		entity.merge(address);
	}

	@Override
	public Address getAddressById(int id) {
		// TODO Auto-generated method stub
		return entity.find(Address.class, id);
	}

	@Override
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		entity.persist(address);
		
	}

}
