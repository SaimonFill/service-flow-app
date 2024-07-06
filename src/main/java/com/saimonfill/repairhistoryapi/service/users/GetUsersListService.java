package com.saimonfill.repairhistoryapi.service.users;

import com.saimonfill.repairhistoryapi.entity.Users;
import com.saimonfill.repairhistoryapi.mapper.UsersMapper;
import com.saimonfill.repairhistoryapi.model.message.users.UsersRS;
import com.saimonfill.repairhistoryapi.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetUsersListService {

	private final UsersRepository usersRepository;
	private final UsersMapper usersMapper;

	public List<UsersRS> getUsersList() {
		List<Users> users = usersRepository.findAll();
		return usersMapper.toUsersListRSFromEntity(users);
	}
}
