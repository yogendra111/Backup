package ksolves.demospringmvc.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import ksolves.demospringmvc.validations.ValidatePassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeModel {

	private Long id;
	@NotNull(message = "Employee name cannot be null")
	@NotEmpty(message = "Employee name cannot be Empty")
	private String firstName;
	@ValidatePassword
	private String lastName;
	private String email;
	private String add;

}
