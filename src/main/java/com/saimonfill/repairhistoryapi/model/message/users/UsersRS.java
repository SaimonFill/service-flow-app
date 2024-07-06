package com.saimonfill.repairhistoryapi.model.message.users;

import com.saimonfill.repairhistoryapi.model.enums.UsersRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UsersRS {

	private String name;
	private String email;
	private String uuid;
	private UsersRoleEnum role;
}
