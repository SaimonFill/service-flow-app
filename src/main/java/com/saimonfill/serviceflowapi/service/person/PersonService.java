package com.saimonfill.serviceflowapi.service.person;

import com.saimonfill.serviceflowapi.entity.Person;
import com.saimonfill.serviceflowapi.model.dto.PersonDTO;

public interface PersonService {

	Person createPerson(PersonDTO personDTO);
}
