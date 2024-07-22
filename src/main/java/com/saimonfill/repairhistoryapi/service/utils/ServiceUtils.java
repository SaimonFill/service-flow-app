package com.saimonfill.repairhistoryapi.service.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceUtils {

	private final PasswordEncoder passwordEncoder;

	public String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

}
