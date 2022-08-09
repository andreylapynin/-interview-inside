package com.inside.interview.service;

import com.inside.interview.entity.Account;
import com.inside.interview.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountServiceImpTest {
    @InjectMocks
    private AccountServiceImp accountServiceImp;
    @Mock
    private AccountRepository accountRepository;

    private Account createAccountForTest() {
        return Account.builder()
                .id(1)
                .name("tester")
                .password("123")
                .build();
    }

    @Test
    public void findUserByLoginTest() {
        Account account = createAccountForTest();
        when(accountRepository.findByName(account.getName())).thenReturn(account);
        assertEquals(account, accountServiceImp.findUserByLogin(account.getName()));
    }

}