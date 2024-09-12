package com.saimonfill.repairhistoryapi.service.address;

import com.saimonfill.repairhistoryapi.entity.Address;
import com.saimonfill.repairhistoryapi.model.dto.AddressDTO;
import jakarta.validation.constraints.NotNull;

public interface AddressService {

	Integer createAddress(AddressDTO address);

	Address getAddressById(@NotNull Integer addressId);
}
