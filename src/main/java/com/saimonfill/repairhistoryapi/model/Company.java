package com.saimonfill.repairhistoryapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Company {
	private String name;
	private String corporateName;
	private String taxPayerId;
}