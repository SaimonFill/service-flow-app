package com.saimonfill.repairhistoryapi.service.company;

import com.saimonfill.repairhistoryapi.mapper.AddressMapper;
import com.saimonfill.repairhistoryapi.mapper.CompanyMapper;
import com.saimonfill.repairhistoryapi.mapper.PersonMapper;
import com.saimonfill.repairhistoryapi.model.dto.AddressDTO;
import com.saimonfill.repairhistoryapi.model.dto.PersonDTO;
import com.saimonfill.repairhistoryapi.model.enums.company.CompanyStatusEnum;
import com.saimonfill.repairhistoryapi.model.message.company.CreateCompanyRQ;
import com.saimonfill.repairhistoryapi.repository.company.CompanyRepository;
import com.saimonfill.repairhistoryapi.service.address.AddressService;
import com.saimonfill.repairhistoryapi.service.address.AddressServiceImpl;
import com.saimonfill.repairhistoryapi.service.person.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository;
	private final CompanyMapper companyMapper;
	private final AddressServiceImpl addressService;
	private final AddressMapper addressMapper;
	private final PersonServiceImpl personService;
	private final PersonMapper personMapper;

	@Override
	public ResponseEntity<Object> createCompany(CreateCompanyRQ createCompanyRQ) {
		try {
			var addressId = addressService.createAddress(addressMapper.toAddressDTOFromRequest(createCompanyRQ.getAddress()));

			final var personDTO = personMapper.toPersonDTOFromRequest(createCompanyRQ.getPerson());
			personDTO.setAddressId(addressId);

			var person = personService.createPerson(personDTO);

			var companyEntity = companyMapper.toCompanyEntityFromRequest(createCompanyRQ.getCompany());
			companyEntity.setStatus(CompanyStatusEnum.CREATED.name());
			companyEntity.setPerson(person);
			
			companyEntity = companyRepository.save(companyEntity);

			return new ResponseEntity<>(companyEntity.getUuid(), HttpStatus.OK);
		} catch (Throwable e) {
			throw new RuntimeException("Error creating company", e);
		}
	}
}
