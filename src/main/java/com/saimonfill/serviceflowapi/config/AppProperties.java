package com.saimonfill.serviceflowapi.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AppProperties {

	@Value("${spring.application.name}")
	private String appName;

	@Value("${jwt.secret}")
	private String secretKey;

}
