package com.saimonfill.repairhistoryapi.api;

import com.saimonfill.repairhistoryapi.model.enums.UsersRolePermissionUtils;
import com.saimonfill.repairhistoryapi.model.message.users.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.users.UsersRS;
import com.saimonfill.repairhistoryapi.service.users.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersApi {

	private final UsersService usersService;

	@Operation(summary = "Get users list")
	@GetMapping
	public ResponseEntity<List<UsersRS>> getUsersList() {
		return new ResponseEntity<>(usersService.getUsersList(), HttpStatus.OK);
	}

	@Operation(summary = "Get user by name")
	@GetMapping("/{name}")
	public ResponseEntity<UsersRS> getUserByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(usersService.getUserByName(name), HttpStatus.OK);
	}

//	@PreAuthorize(UsersRolePermissionUtils.EXP_OWNER_OR_ADMIN)
	@Operation(summary = "Create users")
	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@RequestBody CreateUsersRQ request) {
		return usersService.createUser(request);
	}
}
