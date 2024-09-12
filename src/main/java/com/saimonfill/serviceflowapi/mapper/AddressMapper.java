package com.saimonfill.serviceflowapi.mapper;

import com.saimonfill.serviceflowapi.entity.Address;
import com.saimonfill.serviceflowapi.model.dto.AddressDTO;
import com.saimonfill.serviceflowapi.model.message.company.CreateCompanyRQ;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapperConfig.class)
public interface AddressMapper {

	AddressDTO toAddressDTOFromRequest(CreateCompanyRQ.@Valid Address address);

	Address toAddressEntityFromDTO(AddressDTO address);

	AddressDTO toAddressDTOFromEntity(Address address);
}
