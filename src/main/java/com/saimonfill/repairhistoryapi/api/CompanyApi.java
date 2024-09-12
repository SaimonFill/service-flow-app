package com.saimonfill.repairhistoryapi.api;

import com.saimonfill.repairhistoryapi.model.enums.auth.PermissionUtils;
import com.saimonfill.repairhistoryapi.model.message.company.CreateCompanyRQ;
import com.saimonfill.repairhistoryapi.model.message.user.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.service.company.CompanyService;
import com.saimonfill.repairhistoryapi.service.users.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize(PermissionUtils.EXP_OWNER)
@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyApi {

	private final CompanyService companyService;

	@Operation(summary = "Create company")
	@PostMapping("/create")
	public ResponseEntity<Object> createCompany(@RequestBody CreateCompanyRQ request) {
		return companyService.createCompany(request);
	}
}
