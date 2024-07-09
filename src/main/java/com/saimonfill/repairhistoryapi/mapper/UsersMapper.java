package com.saimonfill.repairhistoryapi.mapper;

import com.saimonfill.repairhistoryapi.entity.User;
import com.saimonfill.repairhistoryapi.model.enums.UsersRolePermissionUtils;
import com.saimonfill.repairhistoryapi.model.message.users.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.users.UsersRS;
import com.saimonfill.repairhistoryapi.service.utils.ServiceUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsersMapper {

	private final ServiceUtils serviceUtils;

	public User toUsersEntityFromRequest(CreateUsersRQ request) {
		User entity = new User();
		entity.setUsername(request.getUsername());
		entity.setEmail(request.getEmail());
		entity.setPassword(serviceUtils.encodePassword(request.getPassword()));
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
