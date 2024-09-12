package com.saimonfill.serviceflowapi.service.security;

import com.saimonfill.serviceflowapi.model.jwt.UserAuthenticated;
import com.saimonfill.serviceflowapi.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		return userRepository.findByEmail(userEmail)
				.map(UserAuthenticated::new)
				.orElseThrow(
						() -> new UsernameNotFoundException("Users Not Found with userEmail: " + userEmail)
				);
	}
}