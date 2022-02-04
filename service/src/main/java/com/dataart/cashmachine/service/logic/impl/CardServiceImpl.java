package com.dataart.cashmachine.service.logic.impl;

import com.dataart.cashmachine.db.entity.CardEntity;
import com.dataart.cashmachine.db.repository.CardRepository;
import com.dataart.cashmachine.service.logic.CardService;
import com.dataart.cashmachine.service.mapper.CardMapper;
import com.dataart.cashmachine.service.mapper.OperationsHistoryMapper;
import com.dataart.cashmachine.service.model.CardDto;
import com.dataart.cashmachine.service.model.OperationsHistoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class CardServiceImpl implements CardService {

    private static final Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);
    private final OperationsHistoryMapper operationsHistoryMapper;
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Autowired
    public CardServiceImpl(OperationsHistoryMapper operationsHistoryMapper,
                           CardRepository cardRepository,
                           CardMapper cardMapper) {
        this.operationsHistoryMapper = operationsHistoryMapper;
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public CardDto getCardById(long cardId) {
        CardEntity cardEntity = cardRepository.findById(cardId).orElseThrow();
        if (cardEntity.getBlocked()) {
            return null;
        }
        return cardMapper.fromEntity(cardEntity);
    }

    @Override
    public Integer getCardBalanceById(long cardId) {
        CardEntity cardEntity = cardRepository.findById(cardId).orElseThrow();
        return cardEntity.getBalance();
    }

    @Override
    @Transactional
    public void blockCardById(long cardId) {
        CardEntity cardEntity = cardRepository.findById(cardId).orElseThrow();
        cardEntity.setBlocked(true);
        cardRepository.save(cardEntity);
    }

    @Override
    public List<OperationsHistoryDto> getAllCompletedOperationsById(long cardId) {
        CardEntity cardEntity = cardRepository.findById(cardId).orElseThrow();
        return operationsHistoryMapper.fromEntities(cardEntity.getOperations());
    }

    @Override
    @Transactional
    public Boolean withdrawCashFromCardById(long cardId, int sum) {
        CardEntity cardEntity = cardRepository.findById(cardId).orElseThrow();
        int currentBalance = cardEntity.getBalance();
        if (currentBalance - sum >= 0) {
            cardEntity.setBalance(currentBalance - sum);
        } else {
            return false;
        }
        cardRepository.save(cardEntity);
        return true;
    }

}
