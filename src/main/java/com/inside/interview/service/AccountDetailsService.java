package com.inside.interview.service;

import com.inside.interview.entity.Account;
import com.inside.interview.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccountDetailsService implements UserDetailsService {
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Account accountData = accountService.findUserByLogin(username);
            Set<GrantedAuthority> roles = new HashSet<>();
            return new User(accountData.getName(), accountData.getPassword(), roles);
        } catch (NoResultException e) {
            throw new UsernameNotFoundException("No user found");
        }
    }

}