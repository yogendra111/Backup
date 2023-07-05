package com.demoboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_tokens")
public class Token {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String token;
	@Enumerated(EnumType.STRING)
	private TokenType tokenType;
	private boolean expired;
	private boolean revoked;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
		
}
