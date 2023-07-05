package com.demoboot.services;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demoboot.auth.AuthenticationRequest;
import com.demoboot.auth.AuthenticationResponse;
import com.demoboot.auth.RegisterRequest;
import com.demoboot.daos.TokenRepository;
import com.demoboot.daos.UserRepository;
import com.demoboot.entities.Role;
import com.demoboot.entities.Token;
import com.demoboot.entities.TokenType;
import com.demoboot.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutheticationService {

	private final UserRepository repository;
	private final TokenRepository tokenRepository;
	private final PasswordEncoder passwordEncoder;
	private final JWTService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(RegisterRequest request) {
		var user = User
				.builder()
				.name(request.getName())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.ADMIN)
				.build();

		repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(user);
		saveToken(user, jwtToken);
		return AuthenticationResponse
				.builder()
				.accessToken(jwtToken)
				.refreshToken(refreshToken)
				.build();
	}
	
	private void revokeAllUserTokens(User user) {
		var validTokens = tokenRepository.findAllValidTokensByUser(user.getId());
		if(validTokens.isEmpty())
			return;
		
		validTokens.forEach(t->{
			t.setExpired(true);
			t.setRevoked(true);
		});
		tokenRepository.saveAll(validTokens);
	}

	private void saveToken(User user, String jwtToken) {
		var token = Token
					.builder()
					.user(user)
					.token(jwtToken)
					.tokenType(TokenType.BEARER)
					.revoked(false)
					.expired(false)
					.build();
		tokenRepository.save(token);
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		System.out.println("He+++++");
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		System.out.println("H______");
		var user = repository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(user);
		revokeAllUserTokens(user);
		saveToken(user, jwtToken);
		return AuthenticationResponse
				.builder()
				.accessToken(jwtToken)
				.refreshToken(refreshToken)
				.build();
	}

	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		final String refreshToken;
		final String userEmail;
		

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return;
		}
		refreshToken = authHeader.substring(7);
		// extract userEmail from Refresh Token
		userEmail = jwtService.extractUsername(refreshToken);
		
		if (userEmail != null) {

			var user = this.repository.findByEmail(userEmail)
								.orElseThrow();
			
			if (jwtService.isTokenValid(refreshToken, user)) {
				var accessToken = jwtService.generateToken(user);
				saveToken(user, accessToken);
				var authResponse = AuthenticationResponse
									.builder()
									.accessToken(accessToken)
									.refreshToken(refreshToken)
									.build();
				new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
			}

		}
		
	}

}
