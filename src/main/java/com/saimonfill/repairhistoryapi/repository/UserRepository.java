package com.saimonfill.repairhistoryapi.repository;

import com.saimonfill.repairhistoryapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	Optional<Users> findByUsername(String userName);

	Optional<Users> findByEmail(String userEmail);
}
