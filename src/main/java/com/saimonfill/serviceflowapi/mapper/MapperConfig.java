package com.saimonfill.serviceflowapi.mapper;

import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@org.mapstruct.MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
		unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface MapperConfig {
}