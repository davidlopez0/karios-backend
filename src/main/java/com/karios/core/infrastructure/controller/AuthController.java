package com.karios.core.infrastructure.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karios.core.domain.dto.LoginDTO;
import com.karios.core.domain.dto.TokenDTO;
import com.karios.core.domain.model.User;
import com.karios.core.infrastructure.config.JwtUtil;
import com.karios.core.infrastructure.mapper.UserMapper;
import com.karios.core.infrastructure.mysqlrepository.UserCrudRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserCrudRepository userCrudRepository;
	@Autowired
	private UserMapper mapper;
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO){
		UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
		Authentication authentication = this.authenticationManager.authenticate(login);
		
		String jwt = this.jwtUtil.create(loginDTO.getUsername());
		
		Optional<User> user = userCrudRepository.findByUsername(loginDTO.getUsername()).map(
					userEntity -> mapper.toDomainUser(userEntity)
				);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, jwt);
		headers.set(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "*");
		
		return ResponseEntity.ok().headers(headers).body(user.get());
	}
	
	@GetMapping("/check-token")
	public ResponseEntity<Boolean> checkToken(@RequestHeader("Authorization") String token) {
		
		String jwt = token.split(" ")[1].trim();
		
		Boolean valid = this.jwtUtil.isValid(jwt);
		if(valid) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		
		return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}
	
}
