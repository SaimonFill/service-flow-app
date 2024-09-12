package com.saimonfill.serviceflowapi.service.person;

import com.saimonfill.serviceflowapi.entity.Person;
import com.saimonfill.serviceflowapi.mapper.PersonMapper;
import com.saimonfill.serviceflowapi.model.dto.PersonDTO;
import com.saimonfill.serviceflowapi.repository.person.PersonRepository;
import com.saimonfill.serviceflowapi.service.address.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;
	private final PersonMapper personMapper;
	private final AddressServiceImpl addressService;

	@Override
	public Person createPerson(PersonDTO personDTO) {
		try {
			final var address = addressService.getAddressById(personDTO.getAddressId());

			if (Objects.isNull(address)) {
				throw new RuntimeException("Address not found");
			}

			var entity = personMapper.toPersonEntityFromDTO(personDTO);
			entity.setAddress(address);

			return personRepository.save(entity);

		} catch (Throwable e) {
			throw new RuntimeException("Error creating person", e);
		}
	}
}
