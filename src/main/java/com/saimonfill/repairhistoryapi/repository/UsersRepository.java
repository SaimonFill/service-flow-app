package com.saimonfill.repairhistoryapi.repository;

import com.saimonfill.repairhistoryapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String userName);

	Optional<User> findByEmail(String userEmail);
}
