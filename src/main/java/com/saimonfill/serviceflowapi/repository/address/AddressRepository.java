package com.saimonfill.serviceflowapi.repository.address;

import com.saimonfill.serviceflowapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
