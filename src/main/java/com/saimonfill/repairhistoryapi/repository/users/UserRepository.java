package com.saimonfill.repairhistoryapi.repository.users;

import com.saimonfill.repairhistoryapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByEmail(String userEmail);

	Optional<Users> findByEmailLikeIgnoreCase(String userEmail);
}
