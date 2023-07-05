package com.demoboot.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demoboot.services.JWTService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomFilter extends OncePerRequestFilter{

	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	private final JWTService jwtService;

//	public CustomFilter(AuthenticationManager authenticationManager) {
//		super();
//		this.authenticationManager = authenticationManager;
//	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authType = request.getHeader("Authorization");
		if(authType==null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		System.out.println("authType: " + authType);
		if(authType.startsWith("Basic")) {
			String token = authType.substring(6);
			byte[] tokenByte = Base64.getDecoder().decode(token);
			String credential = new String(tokenByte, StandardCharsets.UTF_8);
			System.out.println(credential);
			String[] credentials = credential.split(":");
			
			Authentication auth = new UsernamePasswordAuthenticationToken(credentials[0], credentials);
			Authentication newAuth = authenticationManager.authenticate(auth);
			
			if(newAuth.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(newAuth);
			}
		}else
			if(authType.startsWith("Bearer")) {
				String token = authType.substring(7);
				
				if(jwtService.isTokenValid(token)) {
					String user = jwtService.getUsername(token);
					if(user!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
						UserDetails userDetails = userDetailsService.loadUserByUsername(user);
						if(userDetails != null) {
							Authentication auth = new UsernamePasswordAuthenticationToken(user, userDetails.getPassword(), userDetails.getAuthorities());
							Authentication newAuth = authenticationManager.authenticate(auth);
							
							if(newAuth.isAuthenticated()) {
								SecurityContextHolder.getContext().setAuthentication(newAuth);
							}
						}
					}					
				}
				
			}
		
		filterChain.doFilter(request, response);
		
		
		
	}	

}
