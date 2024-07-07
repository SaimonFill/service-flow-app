package com.saimonfill.repairhistoryapi.api;

import com.saimonfill.repairhistoryapi.model.message.users.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.users.UsersRS;
import com.saimonfill.repairhistoryapi.service.users.CreateUserService;
import com.saimonfill.repairhistoryapi.service.users.GetUsersListService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersApi {

	private final GetUsersListService service;
	private final CreateUserService createUserService;

	@Operation(summary = "Get users list")
	@GetMapping
	public ResponseEntity<List<UsersRS>> getUsersList() {
		return new ResponseEntity<>(service.getUsersList(), HttpStatus.OK);
	}

	@Operation(summary = "Get user by name")
	@GetMapping("/{name}")
	public ResponseEntity<UsersRS> getUserByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(service.getUserByName(name), HttpStatus.OK);
	}

	@Operation(summary = "Create users")
	@PostMapping("/create")
	public ResponseEntity<Object> getUsersList(@RequestBody CreateUsersRQ request) {
		return createUserService.createUser(request);
	}
}
