package com.saimonfill.serviceflowapi.mapper;

import com.saimonfill.serviceflowapi.entity.Users;
import com.saimonfill.serviceflowapi.model.message.user.CreateUsersRQ;
import com.saimonfill.serviceflowapi.model.message.user.UsersRS;
import com.saimonfill.serviceflowapi.service.utils.ServiceUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", config = MapperConfig.class)
public interface UsersMapper {

	@Mappings({
			@Mapping(target = "email", source = "request.email"),
			@Mapping(target = "password", expression = "java(encodePassword(request))"),
			@Mapping(target = "authorities", source = "request.authorities")
	})
	Users toUsersEntityFromRequest(CreateUsersRQ request);

	UsersRS toUsersRSFromEntity(Users users);

	default String encodePassword(CreateUsersRQ request) {
		return ServiceUtils.encodePassword(request.getPassword());
	}
}
