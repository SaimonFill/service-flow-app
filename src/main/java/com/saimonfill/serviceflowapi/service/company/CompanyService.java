package com.saimonfill.serviceflowapi.service.company;

import com.saimonfill.serviceflowapi.model.message.company.CreateCompanyRQ;
import org.springframework.http.ResponseEntity;

public interface CompanyService {

	ResponseEntity<Object> createCompany(CreateCompanyRQ createCompanyRQ);

}
