package com.inside.interview.service;

import com.inside.interview.entity.Account;
import com.inside.interview.repository.AccountRepository;
import com.inside.interview.service.interfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImp implements AccountService {
    private AccountRepository accountRepository;

    @Override
    public Account findUserByLogin(String name) {
        return accountRepository.findByName(name);
    }

}