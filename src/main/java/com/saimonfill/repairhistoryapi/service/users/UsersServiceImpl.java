package com.saimonfill.repairhistoryapi.service.users;

import com.saimonfill.repairhistoryapi.entity.Users;
import com.saimonfill.repairhistoryapi.mapper.UsersMapper;
import com.saimonfill.repairhistoryapi.model.message.users.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.users.UsersRS;
import com.saimonfill.repairhistoryapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

	private final UserRepository userRepository;
	private final UsersMapper usersMapper;

	public ResponseEntity<Object> createUser(CreateUsersRQ createUsersRQ) {
		try {
			Users entity = usersMapper.toUsersEntityFromRequest(createUsersRQ);
			userRepository.save(entity);
			UsersRS response = usersMapper.toUsersRSFromEntity(entity);
			log.info("Users created: {}", response);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (DataIntegrityViolationException e) {
			log.error("Data integrity violation when creating user: {}", e.getMessage());
			return new ResponseEntity<>("This email or username is already in use.", HttpStatus.CONFLICT);
		} catch (Exception e) {
			log.error("Error creating user: {}", e.getMessage());
			return new ResponseEntity<>("An unexpected error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public List<UsersRS> getUsersList() {
		List<Users> users = userRepository.findAll();
		return usersMapper.toUsersListRSFromEntity(users);
	}

//	public UsersRS getUserByName(String userName) {
//		var user = userRepository.findByUsername(userName);
//		if (user.isEmpty()) {
//			throw new RuntimeException("Users not found");
//		}
//		return usersMapper.toUsersRSFromEntity(user.get());
//	}
}
