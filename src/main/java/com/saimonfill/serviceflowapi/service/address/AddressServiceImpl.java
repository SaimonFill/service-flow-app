package com.saimonfill.serviceflowapi.service.address;

import com.saimonfill.serviceflowapi.entity.Address;
import com.saimonfill.serviceflowapi.mapper.AddressMapper;
import com.saimonfill.serviceflowapi.model.dto.AddressDTO;
import com.saimonfill.serviceflowapi.repository.address.AddressRepository;
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
