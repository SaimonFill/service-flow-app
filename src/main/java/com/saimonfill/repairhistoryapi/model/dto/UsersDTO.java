package com.saimonfill.repairhistoryapi.model.dto;

import com.saimonfill.repairhistoryapi.model.enums.auth.UsersAuthoritiesEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsersDTO {
	private String email;
	private String password;
	private UsersAuthoritiesEnum authorities;
}