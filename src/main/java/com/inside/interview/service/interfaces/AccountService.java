package com.inside.interview.service.interfaces;

import com.inside.interview.entity.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    Account findUserByLogin(String name);

}