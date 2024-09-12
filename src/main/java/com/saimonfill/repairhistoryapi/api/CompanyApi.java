package com.saimonfill.repairhistoryapi.api;

import com.saimonfill.repairhistoryapi.model.message.company.CreateCompanyRQ;
import com.saimonfill.repairhistoryapi.model.message.user.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.service.users.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@PreAuthorize(PermissionUtils.EXP_OWNER_OR_ADMIN)
@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyApi {

	private final UsersService usersService;

	@Operation(summary = "Create users")
	@PostMapping("/new")
	public ResponseEntity<Object> createUser(@RequestBody CreateUsersRQ request) {
		return usersService.createUser(request);
	}
}
