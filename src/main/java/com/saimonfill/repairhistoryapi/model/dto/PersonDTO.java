package com.saimonfill.repairhistoryapi.model.dto;

import jakarta.validation.constraints.NotNull;
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
	@NotNull
	private Integer companyId;
}