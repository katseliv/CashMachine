package com.dataart.cashmachine.service.security;

import com.dataart.cashmachine.db.entity.CardEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    Profile toProfile(CardEntity cardEntity);

}
