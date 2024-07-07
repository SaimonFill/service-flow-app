package com.saimonfill.repairhistoryapi.service.users;

import com.saimonfill.repairhistoryapi.entity.User;
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
		List<User> users = usersRepository.findAll();
		return usersMapper.toUsersListRSFromEntity(users);
	}

	public UsersRS getUserByName(String name) {
		var user = usersRepository.findByUsername(name);
		if (user.isEmpty()) {
			throw new RuntimeException("User not found");
		}
		return usersMapper.toUsersRSFromEntity(user.get());
	}
}
