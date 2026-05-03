package com.Service.User.Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Service.User.Entity.UserEntity;
import com.Service.User.Repository.userRepository;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@EnableMethodSecurity
public class jwtSecurityFilter extends OncePerRequestFilter {

	private jwtUtility jwtUtil;

	public userRepository repo;

	public jwtSecurityFilter(userRepository userRepo, jwtUtility jwt) {
		this.jwtUtil = jwt;
		this.repo = userRepo;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer ")) {

			String token = header.substring(7);
			try {
				String username = jwtUtil.getUsername(token);

				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					if (jwtUtil.validateToken(token, username)) {
						
						List<String> roles=jwtUtil.getRolesFromToken(token);
						
						List<SimpleGrantedAuthority> authorities=roles.stream().map(SimpleGrantedAuthority::new).toList();
						
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
								username, null, authorities);

						authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}

			} catch (ExpiredJwtException e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;

			} catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
		}

		filterChain.doFilter(request, response);
	}
}
