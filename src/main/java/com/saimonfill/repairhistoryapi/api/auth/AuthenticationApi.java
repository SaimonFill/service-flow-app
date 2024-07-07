package com.saimonfill.repairhistoryapi.api.auth;

import com.saimonfill.repairhistoryapi.service.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationApi {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/authenticate")
	public String authenticate(
			Authentication authentication) {
		return authenticationService.authenticate(authentication);
	}
}