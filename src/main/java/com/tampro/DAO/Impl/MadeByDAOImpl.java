package com.tampro.DAO.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.tampro.DAO.MadeByDAO;
import com.tampro.Entity.MadeBy;

@Repository
public class MadeByDAOImpl  implements MadeByDAO{
	@PersistenceContext
	EntityManager entity;

	@Override
	public void deleteById(MadeBy made) {
		// TODO Auto-generated method stub
		entity.remove(made);
	}

	@Override
	public void updateMadeby(MadeBy madeby) {
		// TODO Auto-generated method stub
		entity.merge(madeby);
	}

	@Override
	public MadeBy getMadeById(int id) {
		// TODO Auto-generated method stub
		return entity.find(MadeBy.class,id);
	}

	@Override
	public List<MadeBy> getMadeByIdCategory(int idCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddMadeby(MadeBy madeby) {
		// TODO Auto-generated method stub
		entity.persist(madeby);
	}

	@Override
	public List<MadeBy> getAllMadeBy() {
		// TODO Auto-generated method stub
		String jpql = "SELECT e FROM MadeBy e";
		return entity.createQuery(jpql,MadeBy.class).getResultList();
	}

}
