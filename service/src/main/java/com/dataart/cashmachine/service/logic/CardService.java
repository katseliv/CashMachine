package com.dataart.cashmachine.service.logic;

import com.dataart.cashmachine.service.model.view_dto.CardBalanceDto;
import com.dataart.cashmachine.service.model.view_dto.CardWithdrawalDto;

public interface CardService {

    void blockCardById(long cardId);

    CardBalanceDto getCardBalanceById(long cardId);

    CardWithdrawalDto withdrawCashFromCardById(long cardId, int sum);

}
