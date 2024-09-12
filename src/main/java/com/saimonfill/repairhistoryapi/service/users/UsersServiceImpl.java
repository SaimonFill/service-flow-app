package com.saimonfill.repairhistoryapi.service.users;

import com.saimonfill.repairhistoryapi.entity.Users;
import com.saimonfill.repairhistoryapi.mapper.UsersMapper;
import com.saimonfill.repairhistoryapi.model.message.user.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.user.UsersRS;
import com.saimonfill.repairhistoryapi.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

	private final UserRepository userRepository;
	private final UsersMapper usersMapper;

	public ResponseEntity<Object> createUser(CreateUsersRQ createUsersRQ) {
		try {
			Users entity = usersMapper.toUsersEntityFromRequest(createUsersRQ);

			entity = userRepository.save(entity);

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

	public ResponseEntity<List<UsersRS>> getUsersList() {
		List<Users> users = userRepository.findAll();
	
		var usersList = users.stream()
				.map(usersMapper::toUsersRSFromEntity)
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(usersList, HttpStatus.OK);
	}

	public ResponseEntity<UsersRS> getUserByEmail(String email) {
		var user = userRepository.findByEmailLikeIgnoreCase(email);
		return user.map(users -> new ResponseEntity<>(usersMapper.toUsersRSFromEntity(users), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
