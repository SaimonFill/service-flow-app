package com.saimonfill.repairhistoryapi.mapper;

import com.saimonfill.repairhistoryapi.entity.User;
import com.saimonfill.repairhistoryapi.model.enums.UsersRolePermissionUtils;
import com.saimonfill.repairhistoryapi.model.message.users.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.users.UsersRS;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersMapper {

	private final PasswordEncoder passwordEncoder;

	public UsersMapper(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public User toUsersEntityFromRequest(CreateUsersRQ request) {
		User entity = new User();
		entity.setUsername(request.getUsername());
		entity.setEmail(request.getEmail());
		entity.setPassword(passwordEncoder.encode(request.getPassword()));
		entity.setAuthorities(UsersRolePermissionUtils.USER);
		return entity;
	}

	public List<UsersRS> toUsersListRSFromEntity(List<User> users) {
		return users.stream()
				.map(this::toUsersRSFromEntity)
				.collect(Collectors.toList());
	}

	public UsersRS toUsersRSFromEntity(User user) {
		return UsersRS.builder()
				.username(user.getUsername())
				.email(user.getEmail())
				.role(user.getAuthorities())
				.uuid(user.getId().toString())
				.build();
	}
}
