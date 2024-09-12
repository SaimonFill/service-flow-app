package com.saimonfill.repairhistoryapi.service.utils;

import com.saimonfill.repairhistoryapi.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ServiceUtils {

	private final PasswordEncoder passwordEncoder;
	private final AppProperties appProperties;

	public String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	public String setAuthorityName(String authority) {
		return appProperties.getAppName().concat("_").concat(authority);
	}

}
