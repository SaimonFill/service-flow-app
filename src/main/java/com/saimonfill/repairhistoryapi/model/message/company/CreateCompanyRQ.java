package com.saimonfill.repairhistoryapi.model.message.company;

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

	@Valid
	private Company company;
	@Valid
	private Person person;
	@Valid
	private Address address;

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
		private String givenName;
		@NotBlank
		private String surName;
		@NotBlank
		private String phoneNumber;
		@NotBlank
		private String taxPayerId;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	@SuperBuilder
	public static class Address {
		@NotBlank
		private String city;
		@NotBlank
		private String country;
		@NotBlank
		private String state;
		@NotBlank
		private String street;
		@NotBlank
		private String zipCode;
		private String complement;
	}
}
