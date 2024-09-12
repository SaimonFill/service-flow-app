package com.saimonfill.repairhistoryapi.api;

import com.saimonfill.repairhistoryapi.model.message.user.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.user.UsersRS;
import com.saimonfill.repairhistoryapi.service.users.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@PreAuthorize(PermissionUtils.EXP_OWNER_OR_ADMIN)
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

	@Operation(summary = "Get user by email")
	@GetMapping("/{email}")
	public ResponseEntity<UsersRS> getUserByName(@PathVariable("email") String email) {
		return new ResponseEntity<>(usersService.getUserByEmail(email), HttpStatus.OK);
	}

	@Operation(summary = "Create users")
	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@RequestBody CreateUsersRQ request) {
		return usersService.createUser(request);
	}
}
