package com.saimonfill.repairhistoryapi.mapper;

import com.saimonfill.repairhistoryapi.entity.Address;
import com.saimonfill.repairhistoryapi.model.dto.AddressDTO;
import com.saimonfill.repairhistoryapi.model.message.company.CreateCompanyRQ;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapperConfig.class)
public interface AddressMapper {

	AddressDTO toAddressDTOFromRequest(CreateCompanyRQ.@Valid Address address);

	Address toAddressEntityFromDTO(AddressDTO address);

	AddressDTO toAddressDTOFromEntity(Address address);
}
