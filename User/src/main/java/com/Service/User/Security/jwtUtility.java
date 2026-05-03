package com.Service.User.Security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.Service.User.Entity.RoleTable;
import com.Service.User.Entity.UserEntity;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

@Component
public class jwtUtility {

	private String SECRETE = "mysecretkeymysecretkeymysecretkey12345";

	private Key getSignKey() {
		return Keys.hmacShaKeyFor(SECRETE.getBytes());
	}

	public String generateToken(UserEntity userdetails) {

		String userName = userdetails.getUsername();
		List<String> role = userdetails.getRoles().stream().map(RoleTable::getRolename).toList();

		String token = Jwts.builder().setSubject(userName).claim("Roles", role).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
		return token;
	}

	// to validate the token we need to get the claims of the
	// token after that we need to extrack the username
	public boolean validateToken(String token, String name) {
		return getUsername(token).equals(name) && !isTokenExpire(token);
	}

	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	public boolean isTokenExpire(String token) {
		return getClaims(token).getExpiration().before(new Date());
	}

	public List<String> getRolesFromToken(String token) {
		Claims claims = getClaims(token);
		return claims.get("Roles", List.class);
	}

	private Claims getClaims(String token) {

		SecretKey key = Keys.hmacShaKeyFor(SECRETE.getBytes(StandardCharsets.UTF_8));
		return Jwts.parserBuilder().setSigningKey(key) // Use your SecretKey here
				.build().parseClaimsJws(token).getBody(); // Replaces getBody()
	}

}
