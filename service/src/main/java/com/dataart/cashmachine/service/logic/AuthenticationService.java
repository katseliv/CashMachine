package com.dataart.cashmachine.service.logic;

import com.dataart.cashmachine.service.model.create_dto.CardCreateDto;

public interface AuthenticationService {

    String generateToken(CardCreateDto dto);

    Boolean verifyToken(long cardId, String token);

}
