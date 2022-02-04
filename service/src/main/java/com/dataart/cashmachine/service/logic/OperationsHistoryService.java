package com.dataart.cashmachine.service.logic;

import com.dataart.cashmachine.service.model.OperationsHistoryDto;
import com.dataart.cashmachine.service.model.create_dto.OperationsHistoryCreateDto;

public interface OperationsHistoryService {

    OperationsHistoryCreateDto addRecordAboutCheckingBalance(long cardId);

    OperationsHistoryCreateDto addRecordAboutWithdrawal(long cardId);

}
