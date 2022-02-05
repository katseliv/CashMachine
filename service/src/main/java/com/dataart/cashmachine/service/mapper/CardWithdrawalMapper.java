package com.dataart.cashmachine.service.mapper;

import com.dataart.cashmachine.db.entity.CardEntity;
import com.dataart.cashmachine.service.model.view_dto.CardWithdrawalDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardWithdrawalMapper {

    CardWithdrawalDto fromEntity(CardEntity entity);

}
