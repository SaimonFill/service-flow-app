package com.saimonfill.repairhistoryapi.repository.address;

import com.saimonfill.repairhistoryapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
