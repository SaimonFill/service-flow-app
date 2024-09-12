package com.saimonfill.repairhistoryapi.service.person;

import com.saimonfill.repairhistoryapi.model.dto.PersonDTO;
import com.saimonfill.repairhistoryapi.repository.person.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	@Override
	public Long createPerson(PersonDTO personDTO) {
		return 0L;
	}
}
