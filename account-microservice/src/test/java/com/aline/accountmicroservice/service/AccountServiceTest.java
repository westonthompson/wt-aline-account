package com.aline.accountmicroservice.service;

import com.aline.core.annotation.test.SpringBootUnitTest;
import com.aline.core.annotation.test.SpringTestProperties;
import com.aline.core.model.account.Account;
import com.aline.core.model.account.AccountStatus;
import com.aline.core.model.account.AccountType;
import com.aline.core.model.account.CheckingAccount;
import com.aline.core.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootUnitTest(SpringTestProperties.DISABLE_WEB_SECURITY)
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @MockBean
    AccountRepository repository;

    @BeforeEach
    void setUp() {
        Account account = CheckingAccount.builder()
                .id(1L)
                .accountNumber("123456789")
                .balance(10000)
                .availableBalance(10000)
                .status(AccountStatus.ACTIVE)
                .build();
        when(repository.findById(1L))
                .thenReturn(Optional.of(account));
    }

    @Test
    @WithMockUser(username = "")
    void test_getAccountById_returns_the_correctAccount() {

        Account account = accountService.getAccountById(1L);
        assertNotNull(account);
        assertEquals(1L, account.getId());
        assertEquals("123456789", account.getAccountNumber());
        assertEquals(AccountType.CHECKING, account.getAccountType());
        assertEquals(10000, account.getBalance());
        assertTrue(account instanceof CheckingAccount);

    }

}
