package com.tampro.DAO.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.DAO.UserDAO;
import com.tampro.Entity.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public User getUserById(int idUser) {
		return entityManager.find(User.class, idUser);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
		//Object ob =  entityManager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(user);
		// phai co bang hibernate_sequence cua id , id phai de auto vi no se dung sequence
		//int key = (int) ob;
		//return key;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User  getUserByUsername(String username) {
		String jpql = "SELECT e FROM User e WHERE  e.username = :username";
		//"where a.id = :ids";		
		try {
			return entityManager.createQuery(jpql,User.class).setParameter("username", username).getSingleResult();
		}catch(NoResultException  e) {
			
			return null;
		}
		
		
	}

	@Override
	public User getUserByEmail(String email) {
		String jpql = "SELECT e FROM User e WHERE  e.email = :email";
		//"where a.id = :ids";		
		try {
			return entityManager.createQuery(jpql,User.class).setParameter("email", email).getSingleResult();
		}catch(NoResultException  e) {
			
			return null;
		}
		
	}

}
