package com.saimonfill.serviceflowapi.service.address;

import com.saimonfill.serviceflowapi.entity.Address;
import com.saimonfill.serviceflowapi.model.dto.AddressDTO;
import jakarta.validation.constraints.NotNull;

public interface AddressService {

	Integer createAddress(AddressDTO address);

	Address getAddressById(@NotNull Integer addressId);
}
