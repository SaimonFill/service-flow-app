package com.saimonfill.serviceflowapi.service.utils;

import com.saimonfill.serviceflowapi.config.AppProperties;
import com.saimonfill.serviceflowapi.service.security.PasswordEncoderService;
import lombok.RequiredArgsConstructor;
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
