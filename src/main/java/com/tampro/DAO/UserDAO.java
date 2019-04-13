package com.tampro.DAO;

import java.util.List;

import com.tampro.Entity.User;

public interface UserDAO {
	
    public User getUserById(int idUser);
	
	public List<User> getAllUser();
	
	public void addUser(User user);
	
	public void deleteUser(User user);
	
	public void updateUser(User user);
	
	public User getUserByUsername(String username);
	
	public User getUserByEmail(String email);

}
