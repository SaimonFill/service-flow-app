package com.saimonfill.repairhistoryapi.mapper;

import com.saimonfill.repairhistoryapi.entity.Person;
import com.saimonfill.repairhistoryapi.model.dto.PersonDTO;
import com.saimonfill.repairhistoryapi.model.message.company.CreateCompanyRQ;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapperConfig.class)
public interface PersonMapper {

	PersonDTO toPersonDTOFromRequest(CreateCompanyRQ.Person person);

	Person toPersonEntityFromDTO(PersonDTO personDTO);
}
