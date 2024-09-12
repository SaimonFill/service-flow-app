package com.saimonfill.repairhistoryapi.service.company;

import com.saimonfill.repairhistoryapi.model.dto.AddressDTO;
import com.saimonfill.repairhistoryapi.model.dto.PersonDTO;
import com.saimonfill.repairhistoryapi.model.message.company.CreateCompanyRQ;
import com.saimonfill.repairhistoryapi.repository.company.CompanyRepository;
import com.saimonfill.repairhistoryapi.service.address.AddressService;
import com.saimonfill.repairhistoryapi.service.address.AddressServiceImpl;
import com.saimonfill.repairhistoryapi.service.person.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository;
	private final AddressServiceImpl addressService;
	private final PersonServiceImpl personService;

	@Override
	public ResponseEntity<Object> createCompany(CreateCompanyRQ createCompanyRQ) {
		var addressId = addressService.createAddress(new AddressDTO());
		var personId = personService.createPerson(new PersonDTO());
		return null;
	}
}
