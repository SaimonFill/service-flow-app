package com.saimonfill.repairhistoryapi.model.message.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateUsersRQ {

	private String name;
	private String email;
	private String passwordHash;
}
