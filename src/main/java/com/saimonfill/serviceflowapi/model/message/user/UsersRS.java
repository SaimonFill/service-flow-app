package com.saimonfill.serviceflowapi.model.message.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UsersRS {

	private String email;
	private String uuid;
	private String authorities;
}
