package com.saimonfill.repairhistoryapi.repository.company;

import com.saimonfill.repairhistoryapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
