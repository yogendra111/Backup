package fileUp.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {
	
	@NotBlank(message = "Name cannot be empty!")
	String name;
	
	@NotBlank(message = "Email cannot be empty!")
	@Email(message = "Invalid email!")
	String email;
	
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{8,}$", message = "Password must contain 8 letter and small alphabet")
	String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(@NotBlank(message = "Name cannot be empty!")
	@NotNull String name,
			@Email(message = "Email cannot be empty!") String email,
			@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{8,}$", message = "Password must contain 8 letter and small alphabet") String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}	

}
