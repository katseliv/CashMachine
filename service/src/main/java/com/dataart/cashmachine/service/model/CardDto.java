package com.dataart.cashmachine.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CardDto {

    private Long id;

    private Integer balance;

    private Boolean isBlocked;

    private UserDto owner;

    private Integer attempts;

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

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public UserDto getOwner() {
        return owner;
    }

    public void setOwner(UserDto owner) {
        this.owner = owner;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

}
