package com.gazorpazorp.model.dtoMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.gazorpazorp.model.Store;
import com.gazorpazorp.model.dto.SampleMinimalDto;


@Mapper(componentModel = "spring")
public interface SampleMapper {
	
	SampleMapper INSTANCE = Mappers.getMapper(SampleMapper.class);
	
	
	@Mapping(target="sample")
	SampleMinimalDto sampleToSampleMinimalDto(Store sample);
}
