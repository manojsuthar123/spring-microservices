package com.batch.management.mapper;

import com.batch.management.model.dto.BatchDto;
import com.batch.management.model.entity.BatchEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BatchMapper {
    BatchMapper MAPPER = Mappers.getMapper(BatchMapper.class);
    BatchDto toBatchDto(BatchEntity batchEntity);

    BatchEntity toBatchEntity(BatchDto batchDto);
}
