package com.saimonfill.serviceflowapi.repository.users;

import com.saimonfill.serviceflowapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByEmail(String userEmail);

	Optional<Users> findByEmailLikeIgnoreCase(String userEmail);
}
