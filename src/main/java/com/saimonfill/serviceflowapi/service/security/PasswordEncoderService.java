package com.saimonfill.serviceflowapi.service.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return "";
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return false;
	}

	@Override
	public boolean upgradeEncoding(String encodedPassword) {
		return PasswordEncoder.super.upgradeEncoding(encodedPassword);
	}
}
