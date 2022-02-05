package com.dataart.cashmachine.service.model.view_dto;

import java.time.Instant;

public class CardBalanceDto {

    private Long id;

    private Integer balance;

    private Instant datetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Instant getDatetime() {
        return datetime;
    }

    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
    }

}
