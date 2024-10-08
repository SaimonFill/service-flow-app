package com.saimonfill.repairhistoryapi.model.message.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UsersRS {

	private String userGiverName;
	private String userSurName;
	private String email;
	private String userId;
	private String role;
}
