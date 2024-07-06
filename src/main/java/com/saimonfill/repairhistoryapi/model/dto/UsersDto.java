package com.saimonfill.repairhistoryapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UsersDto {

	private String name;
	private String email;
	private String passwordHash;
}
