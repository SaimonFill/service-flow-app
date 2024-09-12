package com.saimonfill.serviceflowapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {
	private String givenName;
	private String surName;
	private String phoneNumber;
	private String taxPayerId;
}