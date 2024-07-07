package com.saimonfill.repairhistoryapi.service.users;

import com.saimonfill.repairhistoryapi.entity.User;
import com.saimonfill.repairhistoryapi.mapper.UsersMapper;
import com.saimonfill.repairhistoryapi.model.message.users.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.users.UsersRS;
import com.saimonfill.repairhistoryapi.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateUserService {

	private final UsersRepository usersRepository;
	private final UsersMapper usersMapper;

	public ResponseEntity<Object> createUser(CreateUsersRQ user) {
		try {
			User entity = usersMapper.toUsersEntityFromRequest(user);
			usersRepository.save(entity);
			UsersRS response = usersMapper.toUsersRSFromEntity(entity);
			log.info("User created: {}", response);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (DataIntegrityViolationException e) {
			log.error("Data integrity violation when creating user: {}", e.getMessage());
			return new ResponseEntity<>("This email or username is already in use.", HttpStatus.CONFLICT);
		} catch (Exception e) {
			log.error("Error creating user: {}", e.getMessage());
			return new ResponseEntity<>("An unexpected error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
