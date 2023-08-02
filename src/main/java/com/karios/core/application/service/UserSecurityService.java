package com.karios.core.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.karios.core.infrastructure.entity.UserEntity;
import com.karios.core.infrastructure.mysqlrepository.UserCrudRepository;

@Service
public class UserSecurityService implements UserDetailsService {

	@Autowired
	private UserCrudRepository userCrudRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userCrudRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario no se encontro"));
		
		return User.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles()
				.build();
	}
	
}
