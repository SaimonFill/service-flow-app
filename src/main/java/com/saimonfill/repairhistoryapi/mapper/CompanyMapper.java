package com.saimonfill.repairhistoryapi.mapper;

import com.saimonfill.repairhistoryapi.entity.Company;
import com.saimonfill.repairhistoryapi.model.message.company.CreateCompanyRQ;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapperConfig.class)
public interface CompanyMapper {

	Company toCompanyEntityFromRequest(CreateCompanyRQ.Company company);
}
