package com.saimonfill.serviceflowapi.model.message.user;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateUsersRQ {

	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String authorities;
}
