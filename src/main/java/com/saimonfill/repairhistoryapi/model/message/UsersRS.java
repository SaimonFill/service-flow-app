package com.saimonfill.repairhistoryapi.model.message;

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
}
