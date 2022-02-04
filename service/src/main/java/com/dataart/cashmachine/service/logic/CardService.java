package com.dataart.cashmachine.service.logic;

import com.dataart.cashmachine.service.model.CardDto;
import com.dataart.cashmachine.service.model.OperationsHistoryDto;

import java.util.List;

public interface CardService {

    CardDto getCardById(long cardId);

    Integer getCardBalanceById(long cardId);

    void blockCardById(long cardId);

    List<OperationsHistoryDto> getAllCompletedOperationsById(long cardId);

    Boolean withdrawCashFromCardById(long cardId, int sum);

}
