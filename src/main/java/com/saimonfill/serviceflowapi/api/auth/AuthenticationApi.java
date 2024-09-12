package com.saimonfill.serviceflowapi.api.auth;

import com.saimonfill.serviceflowapi.service.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationApi {

	private final AuthenticationService authenticationService;

	@PostMapping("/authenticate")
	public String authenticate(
			Authentication authentication) {
		return authenticationService.authenticate(authentication);
	}
}