package com.saimonfill.repairhistoryapi.service.address;

import com.saimonfill.repairhistoryapi.entity.Address;
import com.saimonfill.repairhistoryapi.mapper.AddressMapper;
import com.saimonfill.repairhistoryapi.model.dto.AddressDTO;
import com.saimonfill.repairhistoryapi.repository.address.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;
	private final AddressMapper addressMapper;

	@Override
	public Integer createAddress(AddressDTO address) {
		try {
			Address entity = addressRepository.save(addressMapper.toAddressEntityFromDTO(address));
			return entity.getAddressId();
		} catch (Throwable e) {
			throw new RuntimeException("Error creating address", e);
		}
	}

	@Override
	public Address getAddressById(Integer addressId) {
		var entity = addressRepository.findById(addressId);

		return entity.orElse(null);
	}
}
