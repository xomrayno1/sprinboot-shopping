package com.tampro.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tampro.Model.UserDTO;

@Service
public class UserSecurityService  implements UserDetailsService{
	@Autowired
	UserService userService;
	
	private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);	//UserSecurityService
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDTO userDTO = userService.getUserDTOByUsername(username);
		if(userDTO==null)
		{
			LOG.warn("Username {} not found ",username); // se bao log + username
			throw new UsernameNotFoundException("Username " +username+"not found"); // vut ra loi Username +username + notfound;
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority(userDTO.getRole()));
		UserDetails userDetails = new User(userDTO.getUserName(),userDTO.getPassWord(),true,true,true,true,authorities);
		
		return userDetails;
	}

}
