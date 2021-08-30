package com.aline.accountmicroservice.service;

import com.aline.core.dto.response.AccountResponse;
import com.aline.core.exception.notfound.AccountNotFoundException;
import com.aline.core.model.account.Account;
import com.aline.core.repository.AccountRepository;
import com.aline.core.security.annotation.PermitAll;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;
    private final ModelMapper mapper;

    /**
     * Get an account by its primary key.
     * @param id The primary key of the account
     * @return The account with the specified primary key.
     */
    @PermitAll
    @PostAuthorize("@accountAuth.canAccess(returnObject)")
    public Account getAccountById(long id) {
        return repository.findById(id).orElseThrow(AccountNotFoundException::new);
    }

    /**
     * Map account entity to AccountResponse DTO.
     * @param account The account entity to be mapped
     * @return An AccountResponse dto mapped from the passed account entity.
     */
    public AccountResponse mapToResponse(Account account) {
        return mapper.map(account, AccountResponse.class);
    }


}
