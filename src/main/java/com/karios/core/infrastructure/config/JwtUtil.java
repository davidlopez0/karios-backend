package com.karios.core.infrastructure.config;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Component
public class JwtUtil {
	
	private static String SECRET_KEY = "k4r10s";
	private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

	public String create(String username) {
		return JWT.create()
				.withSubject(username)
				.withIssuer("karios")
				.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 1000))
				.sign(ALGORITHM);
	}
	
	public boolean isValid(String jwt) {
		try {
			JWT.require(ALGORITHM)
				.build()
				.verify(jwt);
			return true;
		} catch (JWTVerificationException e) {
			return false;
		}
	}
	
	public String getUsername(String jwt) {
		return JWT.require(ALGORITHM)
					.build()
					.verify(jwt)
					.getSubject();
	}
	
}
