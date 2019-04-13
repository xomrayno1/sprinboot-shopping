package com.tampro.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.tampro.Config.SecurityUtility;
import com.tampro.DAO.UserDAO;
import com.tampro.Entity.Product;
import com.tampro.Entity.User;
import com.tampro.Model.UserDTO;
import com.tampro.Service.AddressService;
import com.tampro.Service.UserService;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	UserDAO userdao;
	@Autowired
	AddressService addressService;
	

	@Override
	public UserDTO getUserDTOById(int id) {
		User user = userdao.getUserById(id);
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(user.getUsername());
		userDTO.setEmail(user.getEmail());
		userDTO.setFirstName(user.getFirstname());
		userDTO.setId(user.getId());
		userDTO.setLastName(user.getLastname());
		userDTO.setPassWord(user.getPassword());
		//userDTO.setPhone(user.getPhone());
		userDTO.setRole(user.getRole());
		
		// set addressdto , goi den addressService tra ve addressDTO  , truyen vao addressID , ham nay nhan vao id de tra ve addressdto
		return userDTO;
	}

	@Override
	public List<UserDTO> getAllUserDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUserDTO(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User localuser = userdao.getUserByUsername(userDTO.getUserName()); // tim xem trong csdl da co username nay chua
		User localUsermail = userdao.getUserByEmail(userDTO.getEmail());
		if(localuser!=null || localUsermail!=null) {
			System.out.println("Them That Bai");
			return false;
		}
		else
		{
			User user = new User();
			user.setEmail(userDTO.getEmail());
			user.setFirstname(userDTO.getFirstName());
			//user.setId(userDTO.getId());
			user.setLastname(userDTO.getLastName());
			user.setPassword(SecurityUtility.passwordEncoder().encode(userDTO.getPassWord()));
			user.setPhone(userDTO.getPhone());
			user.setRole(userDTO.getRole());
			user.setUsername(userDTO.getUserName());
			user.setRole("ROLE_USER");		
			userdao.addUser(user);
			System.out.println("Them Thanh Cong");
			return true;
		}
		
		
	}

	@Override
	public void deleteUserDTOById(int id) {
		// TODO Auto-generated method stub
		User user = userdao.getUserById(id);
		userdao.deleteUser(user);
		
	}

	@Override
	public void updateUserDTO(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User();
		
		user.setEmail(userDTO.getEmail());
		user.setFirstname(userDTO.getFirstName());
		user.setId(userDTO.getId());
		user.setLastname(userDTO.getLastName());
		user.setPassword(userDTO.getPassWord());
		user.setPhone(userDTO.getPhone());
		user.setRole(userDTO.getRole());
		user.setUsername(userDTO.getUserName());
		userdao.updateUser(user);
	}

	@Override
	public UserDTO getUserDTOByUsername(String username) {
		User user = userdao.getUserByUsername(username);
		if(user==null)
		{
			return null;
		}
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(user.getUsername());
		userDTO.setEmail(user.getEmail());
		userDTO.setFirstName(user.getFirstname());
		userDTO.setId(user.getId());
		userDTO.setLastName(user.getLastname());
		userDTO.setPassWord(user.getPassword());
		userDTO.setPhone(user.getPhone());
		userDTO.setRole(user.getRole());
		
		// set addressdto , goi den addressService tra ve addressDTO  , truyen vao addressID , ham nay nhan vao id de tra ve addressdto
		return userDTO;
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		User user = userdao.getUserByEmail(email);
		if(user==null)
		{
			return null;
		}
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(user.getUsername());
		userDTO.setEmail(user.getEmail());
		userDTO.setFirstName(user.getFirstname());
		userDTO.setId(user.getId());
		userDTO.setLastName(user.getLastname());
		userDTO.setPassWord(user.getPassword());
		userDTO.setPhone(user.getPhone());
		userDTO.setRole(user.getRole());
		
		// set addressdto , goi den addressService tra ve addressDTO  , truyen vao addressID , ham nay nhan vao id de tra ve addressdto
		return userDTO;
	}

	

}
