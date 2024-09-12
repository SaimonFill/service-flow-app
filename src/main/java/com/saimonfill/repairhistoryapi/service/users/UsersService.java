package com.saimonfill.repairhistoryapi.service.users;

import com.saimonfill.repairhistoryapi.model.message.user.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.user.UsersRS;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsersService {

	ResponseEntity<Object> createUser(CreateUsersRQ createUsersRQ);

	ResponseEntity<List<UsersRS>> getUsersList();

//	ResponseEntity<UsersRS> getUserByEmail(String email);

}
