package com.saimonfill.repairhistoryapi.model.message.company;

import com.saimonfill.repairhistoryapi.model.enums.auth.UsersAuthoritiesEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateCompanyRQ {

	@NotBlank
	private String userAlphaId;

	@Valid
	private Company company;

	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	@SuperBuilder
	public static class Company {
		@NotBlank
		private String name;
		@NotBlank
		private String corporateName;
		@NotBlank
		private String taxPayerId;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	@SuperBuilder
	public static class Person {
		@NotBlank
		private String name;
		@NotBlank
		private String corporateName;
		@NotBlank
		private String taxPayerId;
	}
}
