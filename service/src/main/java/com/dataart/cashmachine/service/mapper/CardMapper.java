package com.dataart.cashmachine.service.mapper;

import com.dataart.cashmachine.db.entity.CardEntity;
import com.dataart.cashmachine.service.model.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardDto fromEntity(CardEntity entity);

    CardEntity toEntity(CardDto dto);

}
