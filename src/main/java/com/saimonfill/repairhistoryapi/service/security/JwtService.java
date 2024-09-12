package com.saimonfill.repairhistoryapi.service.security;

import com.saimonfill.repairhistoryapi.config.AppProperties;
import com.saimonfill.repairhistoryapi.repository.users.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtService {
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	private final AppProperties appProperties;

	private final UserRepository userRepository;

	public String generateToken(Authentication authentication) {
		Instant now = Instant.now();
		long expiry = 36000L;

		String scope = authentication
				.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors
						.joining(" "));

		var user = userRepository.findByEmail(authentication.getName()).orElseThrow();

		Map<String, Object> claims = new HashMap<>();
		claims.put("scope", scope);
		claims.put("sub", authentication.getName());
		claims.put("userId", user.getUuid());
		claims.put("email", user.getEmail());
		claims.put("iat", now);
		claims.put("exp", now.plusSeconds(expiry));
		claims.put("iss", "spring-security-jwt");

		return doGenerateToken(claims, authentication.getName());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, appProperties.getSecretKey().getBytes()).compact();
	}

}