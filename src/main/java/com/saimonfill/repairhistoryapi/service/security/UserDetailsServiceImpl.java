package com.saimonfill.repairhistoryapi.service.security;

import com.saimonfill.repairhistoryapi.model.jwt.UserAuthenticated;
import com.saimonfill.repairhistoryapi.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		return userRepository.findByEmail(userEmail)
				.map(UserAuthenticated::new)
				.orElseThrow(
						() -> new UsernameNotFoundException("User Not Found with userEmail: " + userEmail)
				);
	}
}