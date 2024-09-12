package com.saimonfill.repairhistoryapi.service.person;

import com.saimonfill.repairhistoryapi.entity.Person;
import com.saimonfill.repairhistoryapi.mapper.PersonMapper;
import com.saimonfill.repairhistoryapi.model.dto.PersonDTO;
import com.saimonfill.repairhistoryapi.repository.person.PersonRepository;
import com.saimonfill.repairhistoryapi.service.address.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

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
