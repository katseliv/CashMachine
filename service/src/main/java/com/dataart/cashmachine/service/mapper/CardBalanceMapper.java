package com.dataart.cashmachine.service.mapper;

import com.dataart.cashmachine.db.entity.CardEntity;
import com.dataart.cashmachine.service.model.view_dto.CardBalanceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardBalanceMapper {

    CardBalanceDto fromEntity(CardEntity entity);

}
