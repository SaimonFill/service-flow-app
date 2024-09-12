package com.saimonfill.serviceflowapi.service.users;

import com.saimonfill.serviceflowapi.model.message.user.CreateUsersRQ;
import com.saimonfill.serviceflowapi.model.message.user.UsersRS;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsersService {

	ResponseEntity<Object> createUser(CreateUsersRQ createUsersRQ);

	ResponseEntity<List<UsersRS>> getUsersList();

//	ResponseEntity<UsersRS> getUserByEmail(String email);

}
