package com.dataart.cashmachine.security.impl;

import com.dataart.cashmachine.db.entity.CardEntity;
import com.dataart.cashmachine.db.provider.CardSecurityProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CardSecurityProvider cardSecurityProvider;

    @Autowired
    public UserDetailsServiceImpl(CardSecurityProvider cardSecurityProvider) {
        this.cardSecurityProvider = cardSecurityProvider;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CardEntity cardEntity = cardSecurityProvider.findByCardNumber(Long.parseLong(username));
        return new User(
                cardEntity.getId().toString(),
                cardEntity.getPincode(),
                List.of(new SimpleGrantedAuthority("USER")));
    }

}
