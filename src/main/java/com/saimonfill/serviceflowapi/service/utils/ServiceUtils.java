package com.saimonfill.serviceflowapi.service.utils;

import com.saimonfill.serviceflowapi.service.security.PasswordEncoderService;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceUtils {

	public static String encodePassword(String password) {
		PasswordEncoderService passwordEncoderService = new PasswordEncoderService();
		return passwordEncoderService.encode(password);
	}

}
