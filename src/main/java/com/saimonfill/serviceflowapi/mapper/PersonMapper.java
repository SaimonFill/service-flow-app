package com.saimonfill.serviceflowapi.mapper;

import com.saimonfill.serviceflowapi.entity.Person;
import com.saimonfill.serviceflowapi.model.dto.PersonDTO;
import com.saimonfill.serviceflowapi.model.message.company.CreateCompanyRQ;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapperConfig.class)
public interface PersonMapper {

	PersonDTO toPersonDTOFromRequest(CreateCompanyRQ.Person person);

	Person toPersonEntityFromDTO(PersonDTO personDTO);
}
