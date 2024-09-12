package com.saimonfill.repairhistoryapi.service.person;

import com.saimonfill.repairhistoryapi.entity.Person;
import com.saimonfill.repairhistoryapi.model.dto.PersonDTO;

public interface PersonService {

	Person createPerson(PersonDTO personDTO);
}
