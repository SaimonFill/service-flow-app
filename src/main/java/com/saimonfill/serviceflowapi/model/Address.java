package com.saimonfill.serviceflowapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {
	private String city;
	private String country;
	private String state;
	private String street;
	private String zipCode;
	private String complement;
}