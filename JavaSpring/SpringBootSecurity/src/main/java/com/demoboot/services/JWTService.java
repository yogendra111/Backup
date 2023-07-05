package com.demoboot.services;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	private Claims claims;
	
	public String generateToken(String userName) {
//		authenticationManager
//		.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userName);
	}

	private String createToken(Map<String, Object> claims, String userName) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userName)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	}
	
	public void getClaims(String jwtToken) throws JwtException{
		this.claims = Jwts
				.parserBuilder()
				.setSigningKey(getSignKey())
				.build()
				.parseClaimsJws(jwtToken)
				.getBody();
	}
	
	public Boolean isTokenValid(String jwtToken) {
		try {
			getClaims(jwtToken);
		    return true;
		} catch (MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
		    System.out.println("Error in Token " + e.getMessage());
		}
		return false;
	}
	
//	public Boolean isTokenValid(String jwtToken){
//		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parsePlaintextJwt(jwtToken).getBody();
//	}

	public String getUsername(String jwtToken) {
		return this.claims.getSubject();
	}

	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode("38782F413F4428472B4B6250655368566D597133743677397924422645294840");
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
