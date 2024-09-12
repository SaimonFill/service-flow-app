package com.saimonfill.serviceflowapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonDTO {
	private String givenName;
	private String surName;
	private String phoneNumber;
	private String taxPayerId;
	private Integer addressId;
}