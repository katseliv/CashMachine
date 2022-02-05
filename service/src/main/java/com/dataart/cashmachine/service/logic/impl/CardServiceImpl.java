package com.dataart.cashmachine.service.logic.impl;

import com.dataart.cashmachine.db.entity.CardEntity;
import com.dataart.cashmachine.db.repository.CardRepository;
import com.dataart.cashmachine.service.logic.CardService;
import com.dataart.cashmachine.service.mapper.CardBalanceMapper;
import com.dataart.cashmachine.service.mapper.CardWithdrawalMapper;
import com.dataart.cashmachine.service.model.view_dto.CardBalanceDto;
import com.dataart.cashmachine.service.model.view_dto.CardWithdrawalDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;

@Service
@Validated
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardBalanceMapper cardBalanceMapper;
    private final CardWithdrawalMapper cardWithdrawalMapper;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository,
                           CardBalanceMapper cardBalanceMapper, CardWithdrawalMapper cardWithdrawalMapper) {
        this.cardRepository = cardRepository;
        this.cardBalanceMapper = cardBalanceMapper;
        this.cardWithdrawalMapper = cardWithdrawalMapper;
    }

    @Override
    @Transactional
    public void blockCardById(long cardId) {
        CardEntity cardEntity = cardRepository.findById(cardId).orElseThrow();
        cardEntity.setBlocked(true);
        cardRepository.save(cardEntity);
    }

    @Override
    @Transactional
    public CardBalanceDto getCardBalanceById(long cardId) {
        CardEntity cardEntity = cardRepository.findById(cardId).orElseThrow();
        CardBalanceDto cardBalanceDto = cardBalanceMapper.fromEntity(cardEntity);
        cardBalanceDto.setDatetime(Instant.now());
        return cardBalanceDto;
    }

    @Override
    @Transactional
    public CardWithdrawalDto withdrawCashFromCardById(long cardId, int sum) {
        CardEntity cardEntity = cardRepository.findById(cardId).orElseThrow();
        int currentBalance = cardEntity.getBalance();
        if (currentBalance - sum >= 0) {
            cardEntity.setBalance(currentBalance - sum);
        } else {
            return null;
        }
        cardRepository.save(cardEntity);
        CardWithdrawalDto cardWithdrawalDto = cardWithdrawalMapper.fromEntity(cardEntity);
        cardWithdrawalDto.setSum(sum);
        cardWithdrawalDto.setDatetime(Instant.now());
        return cardWithdrawalDto;
    }

}
