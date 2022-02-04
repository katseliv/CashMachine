package com.dataart.cashmachine.service.model.create_dto;

import com.dataart.cashmachine.service.model.CardDto;
import com.dataart.cashmachine.service.model.OperationDto;

import java.time.Instant;

public class OperationsHistoryCreateDto {

    private Instant datetime;

    private CardDto card;

    private OperationDto operation;

    public Instant getDatetime() {
        return datetime;
    }

    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
    }

    public CardDto getCard() {
        return card;
    }

    public void setCard(CardDto card) {
        this.card = card;
    }

    public OperationDto getOperation() {
        return operation;
    }

    public void setOperation(OperationDto operation) {
        this.operation = operation;
    }

}
