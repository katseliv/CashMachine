package com.dataart.cashmachine.db.provider;

import com.dataart.cashmachine.db.entity.CardEntity;

public interface UserSecurityProvider {

    CardEntity findByCardNumber(Long number);

}
