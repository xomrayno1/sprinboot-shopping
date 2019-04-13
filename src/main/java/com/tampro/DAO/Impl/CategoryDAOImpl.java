package com.tampro.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.DAO.CategoryDAO;
import com.tampro.Entity.Category;
import com.tampro.Entity.MadeBy;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO{

	@PersistenceContext
	EntityManager entityManager; 
	@Autowired
	JdbcTemplate jdbcTeamplate;
	/*
SELECT shopping.category.name,shopping.madeby.name,shopping.madeby.id FROM shopping.category_madeby 
inner join category on category_madeby.category_id = category.id
inner join  madeby on category_madeby.madeby_id = madeby.id
where category.id = 1;
*/
	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Category.class, id);
	}

	@Override
	public List<Category> getAllCategory() {
		String jql = "SELECT e FROM Category e  ";
		return entityManager.createQuery(jql,Category.class).getResultList();
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		entityManager.persist(category);
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		entityManager.remove(category);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		entityManager.merge(category);
	}

	@Override
	public List<MadeBy> getAllMadeByIdCategory(int idCategory) {
		String sql  = "SELECT madeby.name,madeby.id FROM category_madeby inner join category on category_madeby.category_id = category.id inner join  madeby on category_madeby.madeby_id = madeby.id\r\n" + 
				"where category.id = ?";
		return jdbcTeamplate.query(sql, new Object[] {idCategory},new RowMapper<MadeBy>() {

			@Override
			public MadeBy mapRow(ResultSet rs, int rowNum) throws SQLException {
			   MadeBy made = new MadeBy();
			   made.setId(rs.getInt("id"));
			   made.setName(rs.getString("name"));
				return made;
			}
			
		});
		// TODO Auto-generated method stub
		
	}

	/*@Override
 	public List<MadeBy> getAllMadeByIdCategory(int idCategory){
		 String jpql = "SELECT shopping.category.name,shopping.madeby.name,shopping.madeby.id FROM shopping.category_madeby \r\n" + 
				"inner join category on category_madeby.category_id = category.id\r\n" + 
				"inner join  madeby on category_madeby.madeby_id = madeby.id\r\n" + 
				"where category.id = 1";
		
		String jpql = "SELECT b.name,b.id FROM Category_Madeby a \r\n" + 
				" join Category b on a.category_id = :b.id\r\n" + 
				" join  MadeBy c on a.madeby_id  = :c.id\r\n" + 
				"where a.id = :ids";
		return entityManager.createQuery(jpql,MadeBy.class).setParameter("ids",idCategory).getResultList();
	}
    */
	
}
