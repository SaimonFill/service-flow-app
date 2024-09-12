package com.saimonfill.repairhistoryapi.service.company;

import com.saimonfill.repairhistoryapi.model.message.company.CreateCompanyRQ;
import com.saimonfill.repairhistoryapi.model.message.user.CreateUsersRQ;
import com.saimonfill.repairhistoryapi.model.message.user.UsersRS;
import org.springframework.http.ResponseEntity;

import javax.annotation.PostConstruct;
import java.util.List;

public interface CompanyService {

	ResponseEntity<Object> createCompany(CreateCompanyRQ createCompanyRQ);

}
