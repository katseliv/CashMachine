package com.dataart.cashmachine.service.security;

import org.immutables.value.Value;

@Value.Immutable
public interface Profile {

    Integer getId();

    String isBlocked();

}
