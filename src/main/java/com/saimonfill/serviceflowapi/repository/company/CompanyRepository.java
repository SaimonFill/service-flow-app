package com.saimonfill.serviceflowapi.repository.company;

import com.saimonfill.serviceflowapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
