package com.saimonfill.repairhistoryapi.api;

import com.saimonfill.repairhistoryapi.model.enums.UsersRolePermissionUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private")
@PreAuthorize(UsersRolePermissionUtils.EXP_ADMIN)
public class PrivateApi {

	@GetMapping
	public String getMessage() {
		var securityContext = org.springframework.security.core.context.SecurityContextHolder.getContext();
		return "Hello from private API controller";
	}
}