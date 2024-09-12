package com.saimonfill.repairhistoryapi.repository.person;

import com.saimonfill.repairhistoryapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
