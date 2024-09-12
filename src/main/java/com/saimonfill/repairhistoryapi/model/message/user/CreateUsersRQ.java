package com.saimonfill.repairhistoryapi.model.message.user;

import com.saimonfill.repairhistoryapi.model.enums.auth.UsersAuthoritiesEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateUsersRQ {

	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private UsersAuthoritiesEnum authorities;
}
