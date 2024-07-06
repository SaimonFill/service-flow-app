package com.saimonfill.repairhistoryapi.service.users;

import com.saimonfill.repairhistoryapi.entity.Users;
import com.saimonfill.repairhistoryapi.mapper.UsersMapper;
import com.saimonfill.repairhistoryapi.model.message.users.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {

	private final UsersRepository usersRepository;
	private final UsersMapper usersMapper;

	public void createUser(CreateUsersRQ user) {
		Users entity = usersMapper.toUsersEntityFromRequest(user);
		usersRepository.save(entity);
	}
}
