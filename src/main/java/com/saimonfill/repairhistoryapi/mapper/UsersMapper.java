package com.saimonfill.repairhistoryapi.mapper;

import com.saimonfill.repairhistoryapi.entity.Users;
import com.saimonfill.repairhistoryapi.model.enums.UsersRoleEnum;
import com.saimonfill.repairhistoryapi.model.message.users.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.users.UsersRS;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersMapper {

	public Users toUsersEntityFromRequest(CreateUsersRQ request) {
		Users entity = new Users();
		entity.setName(request.getName());
		entity.setEmail(request.getEmail());
		entity.setPasswordHash(request.getPasswordHash());
		entity.setRole(UsersRoleEnum.USER);
		return entity;
	}

	public List<UsersRS> toUsersListRSFromEntity(List<Users> users) {
		return users.stream()
				.map(this::toUsersRSFromEntity)
				.collect(Collectors.toList());
	}

	public UsersRS toUsersRSFromEntity(Users user) {
		return UsersRS.builder()
				.name(user.getName())
				.email(user.getEmail())
				.uuid(user.getUuid())
				.role(user.getRole())
				.build();
	}
}
