package com.saimonfill.serviceflowapi.api;

import com.saimonfill.serviceflowapi.model.enums.auth.PermissionUtils;
import com.saimonfill.serviceflowapi.model.message.user.CreateUsersRQ;
import com.saimonfill.serviceflowapi.model.message.user.UsersRS;
import com.saimonfill.serviceflowapi.service.users.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersApi {

	private final UsersService usersService;

	@Operation(summary = "Create users")
	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@RequestBody CreateUsersRQ request) {
		return usersService.createUser(request);
	}

	@PreAuthorize(PermissionUtils.EXP_OWNER_OR_ADMIN)
	@Operation(summary = "Get users list")
	@GetMapping
	public ResponseEntity<List<UsersRS>> getUsersList() {
		return usersService.getUsersList();
	}

//	@PreAuthorize(PermissionUtils.EXP_OWNER_OR_ADMIN)
//	@Operation(summary = "Get user by email")
//	@GetMapping("/{email}")
//	public ResponseEntity<UsersRS> getUserByName(@PathVariable("email") String email) {
//		return usersService.getUserByEmail(email);
//	}
}
