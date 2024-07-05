package com.saimonfill.repairhistoryapi.api;

import com.saimonfill.repairhistoryapi.model.message.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.UsersRS;
import com.saimonfill.repairhistoryapi.service.users.CreateUserService;
import com.saimonfill.repairhistoryapi.service.users.GetUsersListService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
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
	public List<UsersRS> getUsersList() {
		return service.getUsersList();
	}

	@Operation(summary = "Create users")
	@PostMapping
	public void getUsersList(@RequestBody CreateUsersRQ request) {
		createUserService.createUser(request);
	}
}
