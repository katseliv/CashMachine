package com.dataart.cashmachine.service.mapper;

import com.dataart.cashmachine.db.entity.OperationsHistoryEntity;
import com.dataart.cashmachine.service.model.OperationsHistoryDto;
import com.dataart.cashmachine.service.model.create_dto.OperationsHistoryCreateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OperationsHistoryMapper {

    OperationsHistoryDto fromEntity(OperationsHistoryEntity entity);

    OperationsHistoryEntity toEntity(OperationsHistoryDto dto);

    OperationsHistoryEntity toEntity(OperationsHistoryCreateDto dto);

    List<OperationsHistoryDto> fromEntities(Iterable<OperationsHistoryEntity> entities);

}
