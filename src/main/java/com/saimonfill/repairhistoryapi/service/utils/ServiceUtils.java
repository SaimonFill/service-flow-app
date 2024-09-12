package com.saimonfill.repairhistoryapi.service.utils;

import com.saimonfill.repairhistoryapi.config.AppProperties;
import com.saimonfill.repairhistoryapi.service.security.PasswordEncoderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceUtils {

	private final AppProperties appProperties;

	public static String encodePassword(String password) {
		PasswordEncoderService passwordEncoderService = new PasswordEncoderService();
		return passwordEncoderService.encode(password);
	}

	public String setAuthorityName(String authority) {
		return appProperties.getAppName().concat("_").concat(authority);
	}

}
