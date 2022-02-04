package com.dataart.cashmachine.service.mapper;

import com.dataart.cashmachine.db.entity.OperationEntity;
import com.dataart.cashmachine.service.model.OperationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationMapper {

    OperationDto fromEntity(OperationEntity entity);

    OperationEntity toEntity(OperationDto dto);

}
