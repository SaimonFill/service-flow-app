package com.saimonfill.repairhistoryapi.repository;

import com.saimonfill.repairhistoryapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmail(String userEmail);

	Optional<Users> findByEmailLikeIgnoreCase(String userEmail);
}
