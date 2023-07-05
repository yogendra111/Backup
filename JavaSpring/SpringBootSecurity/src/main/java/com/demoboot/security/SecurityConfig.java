package com.demoboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.demoboot.services.JWTService;
import com.demoboot.services.UserInfoDetailService;

import lombok.RequiredArgsConstructor;

@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
public class SecurityConfig {
	
	@Autowired
	private JWTService jwtService;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
		SecurityFilterChain webFilterChain = http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((requests) -> {
					try {
						requests.requestMatchers("/authenticate", "/new").permitAll();
						requests.requestMatchers("/router/**").hasRole("ADMIN");
						requests.anyRequest().authenticated();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).httpBasic(Customizer.withDefaults())
				.addFilterBefore(new CustomFilter(authenticationManager, userDetailsService, jwtService), UsernamePasswordAuthenticationFilter.class)
				.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();

//		http.authorizeHttpRequests((requests) -> {
//			try {
//				requests.requestMatchers("/router/**").authenticated().anyRequest().hasRole("ADMIN");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
		webFilterChain.getFilters().stream().forEach(System.out::println);
		return webFilterChain;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	InMemoryUserDetailsManager userDetailsManager(PasswordEncoder encoder) {
//
//		UserDetails admin = User.withUsername("admin").password(encoder.encode("abcd")).roles("ADMIN").build();
//		UserDetails user = User.withUsername("user").password(encoder.encode("1234")).roles("USER").build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}
	
//	public UserDetailsService userDetailsService() {
//		return new UserInfoDetailService();
//	}

	@Bean
	AuthenticationProvider authenticationProvider(UserInfoDetailService userInfoDetailService,PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(passwordEncoder);
		authenticationProvider.setUserDetailsService(userInfoDetailService);
		return authenticationProvider;
	}

//	@Autowired
//	private CustomAuthenticationProvider authProvider;

	@Bean
	AuthenticationManager authenticationManager(CustomAuthenticationProvider authenticationProvider,
			HttpSecurity httpSecurity) throws Exception {

		AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity
				.getSharedObject(AuthenticationManagerBuilder.class);

		authenticationManagerBuilder.authenticationProvider(authenticationProvider);
		return authenticationManagerBuilder.build();

	}

}
