package com.dataart.cashmachine.db.provider;

import com.dataart.cashmachine.db.entity.CardEntity;

public interface CardSecurityProvider {

    CardEntity findByCardNumber(Long number);

}
