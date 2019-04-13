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

import com.tampro.DAO.ProductDAO;
import com.tampro.Entity.Product;


@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@PersistenceContext
	EntityManager entity;
	@Autowired
	JdbcTemplate jdbcTeamplate;

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return entity.find(Product.class, id);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		String jpql = "SELECT e FROM Product e ";
		return entity.createQuery(jpql,Product.class).getResultList();
		
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		entity.persist(product);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		entity.remove(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		entity.merge(product);
	}
	@Override
	public List<Product> getProductByIdCategory(int idCategory) {
		String jpql = "SELECT e FROM Product e WHERE e.category_id = :id ";
		
		return entity.createQuery(jpql, Product.class).setParameter("id", idCategory).getResultList();
	}

	@Override
	public List<Product> get8ProductByDateNews() {
		// TODO Auto-generated method stub
		String sql = "select * from product order by product.date desc limit 8";
		return jdbcTeamplate.query(sql, new Object[] {},new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Product product = new Product();
				product.setCategoryid(rs.getInt("category_id"));
				product.setId(rs.getInt("id"));
				product.setMadebyid(rs.getInt("madeby_id"));
				product.setPrice(rs.getString("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setDate(rs.getString("date"));
				product.setDescribe(rs.getString("describe"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setUrl(rs.getString("url"));
				return product;
			}
			
		});
		
	}

	@Override
	public Product getProductByUrl(String url) {
     String jpql = "SELECT e FROM Product e WHERE e.url = :url ";
		
		return entity.createQuery(jpql, Product.class).setParameter("url", url).getSingleResult();
		
	}

	@Override
	public int getQuantity(int idProduct) {
		String jpql ="SELECT e.quantity From Product e where e.id = :id";
		// TODO Auto-generated method stub
		
		return entity.createQuery(jpql,Integer.class).setParameter("id", idProduct).getSingleResult();
	}

}
