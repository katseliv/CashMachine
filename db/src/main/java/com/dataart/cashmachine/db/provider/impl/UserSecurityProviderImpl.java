package com.dataart.cashmachine.db.provider.impl;

import com.dataart.cashmachine.db.entity.CardEntity;
import com.dataart.cashmachine.db.provider.CardSecurityProvider;
import com.dataart.cashmachine.db.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CardSecurityProviderImpl implements CardSecurityProvider {

    private final CardRepository repository;

    @Autowired
    public CardSecurityProviderImpl(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public CardEntity findByCardNumber(Long number) {
        return repository.findById(number).orElseThrow();
    }

}
