package com.saimonfill.repairhistoryapi.service.address;

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

	@Override
	public Integer createAddress(AddressDTO address) {
		return 0;
	}
}
