package com.saimonfill.serviceflowapi.mapper;

import com.saimonfill.serviceflowapi.entity.Company;
import com.saimonfill.serviceflowapi.model.message.company.CreateCompanyRQ;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapperConfig.class)
public interface CompanyMapper {

	Company toCompanyEntityFromRequest(CreateCompanyRQ.Company company);
}
