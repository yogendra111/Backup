package com.demoboot.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
	
	private final JWTAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	private final LogoutHandler logoutHandler;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf(c->c.disable())
		.authorizeHttpRequests(
			request -> {
				System.out.println("Inside authorizeHttpRequests");
				request.requestMatchers("/auth/**").permitAll()
				.anyRequest().authenticated();
			}
		).sessionManagement(
				session -> {
					System.out.println("Inside sessionManagement");
					session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				}
		).authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
		.logout(
				l->{
					l.logoutUrl("/auth/logout");
					l.addLogoutHandler(logoutHandler);
					l.logoutSuccessHandler(
							(request, response, authentication) -> {
								SecurityContextHolder.clearContext();
								response.getWriter().print("Logout Sucessful!!");
							}								
						);
				}
			);
		
		return http.build();
	}
}
