package com.dataart.cashmachine.service.logic.impl;

import com.dataart.cashmachine.db.repository.CardRepository;
import com.dataart.cashmachine.db.repository.OperationRepository;
import com.dataart.cashmachine.db.repository.OperationsHistoryRepository;
import com.dataart.cashmachine.service.logic.OperationsHistoryService;
import com.dataart.cashmachine.service.mapper.CardMapper;
import com.dataart.cashmachine.service.mapper.OperationMapper;
import com.dataart.cashmachine.service.mapper.OperationsHistoryMapper;
import com.dataart.cashmachine.service.model.create_dto.OperationsHistoryCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OperationsHistoryServiceImpl implements OperationsHistoryService {

    private final OperationsHistoryRepository operationsHistoryRepository;
    private final OperationsHistoryMapper operationsHistoryMapper;
    private final OperationRepository operationRepository;
    private final OperationMapper operationMapper;
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Autowired
    public OperationsHistoryServiceImpl(OperationsHistoryRepository operationsHistoryRepository,
                                        OperationsHistoryMapper operationsHistoryMapper, OperationRepository operationRepository,
                                        OperationMapper operationMapper,
                                        CardRepository cardRepository,
                                        CardMapper cardMapper) {
        this.operationsHistoryRepository = operationsHistoryRepository;
        this.operationsHistoryMapper = operationsHistoryMapper;
        this.operationRepository = operationRepository;
        this.operationMapper = operationMapper;
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public OperationsHistoryCreateDto addRecordAboutCheckingBalance(long cardId) {
        OperationsHistoryCreateDto operationsHistoryCreateDto = new OperationsHistoryCreateDto();
        operationsHistoryCreateDto.setOperation(operationMapper.fromEntity(operationRepository.findById(1).orElseThrow()));
        operationsHistoryCreateDto.setDatetime(Instant.now());
        operationsHistoryCreateDto.setCard(cardMapper.fromEntity(cardRepository.findById(cardId).orElseThrow()));

        operationsHistoryRepository.save(operationsHistoryMapper.toEntity(operationsHistoryCreateDto));

        return operationsHistoryCreateDto;
    }

    @Override
    public OperationsHistoryCreateDto addRecordAboutWithdrawal(long cardId) {
        OperationsHistoryCreateDto operationsHistoryCreateDto = new OperationsHistoryCreateDto();
        operationsHistoryCreateDto.setOperation(operationMapper.fromEntity(operationRepository.findById(2).orElseThrow()));
        operationsHistoryCreateDto.setDatetime(Instant.now());
        operationsHistoryCreateDto.setCard(cardMapper.fromEntity(cardRepository.findById(cardId).orElseThrow()));

        operationsHistoryRepository.save(operationsHistoryMapper.toEntity(operationsHistoryCreateDto));

        return operationsHistoryCreateDto;
    }

}
