package com.dataart.cashmachine.service.logic.impl;

import com.dataart.cashmachine.db.entity.CardEntity;
import com.dataart.cashmachine.db.repository.CardRepository;
import com.dataart.cashmachine.service.logic.AuthenticationService;
import com.dataart.cashmachine.service.model.create_dto.CardCreateDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    private final CardRepository cardRepository;
    private final Map<Long, String> authDetails = new HashMap<>();
//    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthenticationServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public String generateToken(CardCreateDto dto) {
//        CardEntity cardEntity = cardRepository.findById(dto.getId()).orElseThrow();
//
//        String pincode = passwordEncoder.encode(dto.getPincode());
//        if (pincode.equals(cardEntity.getPincode())) {
//            String token = UUID.randomUUID().toString();
//            authDetails.put(dto.getId(), token);
//            return token;
//        } else {
//            int attempts = cardEntity.getAttempts() + 1;
//            cardEntity.setAttempts(attempts);
//            if (attempts > 4){
//                cardEntity.setBlocked(true);
//                cardRepository.save(cardEntity);
//                return "Card was blocked";
//            } else {
//                cardRepository.save(cardEntity);
//                return "Wrong pin code";
//            }
//        }
        return "";
    }

    @Override
    public Boolean verifyToken(long cardId, String token) {
        String existingToken = authDetails.get(cardId);

        if (existingToken != null && existingToken.equals(token)) {
            authDetails.remove(cardId);
            return true;
        } else {
            return false;
        }
    }

}
