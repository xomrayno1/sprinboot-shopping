package com.tampro.Service;

import java.util.List;

import com.tampro.Model.UserDTO;

    public interface UserService {
    public UserDTO getUserDTOById(int id);
	
	public List<UserDTO> getAllUserDTO();
	
	public boolean addUserDTO(UserDTO userDTO);
	
	public void deleteUserDTOById(int id);
	
	public void updateUserDTO(UserDTO userDTO);
	
	public UserDTO getUserDTOByUsername(String username);
	
	public UserDTO getUserByEmail(String email);
	
	
	
	

}
