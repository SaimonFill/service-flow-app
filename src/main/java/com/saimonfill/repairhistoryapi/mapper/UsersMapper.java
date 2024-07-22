package com.saimonfill.repairhistoryapi.mapper;

import com.saimonfill.repairhistoryapi.entity.Users;
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

	public Users toUsersEntityFromRequest(CreateUsersRQ request) {
		Users entity = new Users();
		entity.setUsername(request.getUsername());
		entity.setEmail(request.getEmail());
		entity.setPassword(serviceUtils.encodePassword(request.getPassword()));
		entity.setAuthorities(request.getAuthorities().toString());
		return entity;
	}

	public List<UsersRS> toUsersListRSFromEntity(List<Users> users) {
		return users.stream()
				.map(this::toUsersRSFromEntity)
				.collect(Collectors.toList());
	}

	public UsersRS toUsersRSFromEntity(Users users) {
		return UsersRS.builder()
				.username(users.getUsername())
				.email(users.getEmail())
				.role(users.getAuthorities())
				.userId(users.getUserId().toString())
				.build();
	}
}
