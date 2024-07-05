package com.saimonfill.repairhistoryapi.repository;

import com.saimonfill.repairhistoryapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
