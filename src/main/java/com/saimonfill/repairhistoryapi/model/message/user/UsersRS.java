package com.saimonfill.repairhistoryapi.model.message.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UsersRS {

	private String email;
	private String userId;
	private String role;
}
