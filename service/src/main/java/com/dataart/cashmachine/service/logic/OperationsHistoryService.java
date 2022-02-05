package com.dataart.cashmachine.service.logic;

public interface OperationsHistoryService {

    void addRecordAboutCheckingBalance(long cardId);

    void addRecordAboutWithdrawal(long cardId);

}
