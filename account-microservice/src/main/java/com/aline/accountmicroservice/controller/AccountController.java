package com.aline.accountmicroservice.controller;

import com.aline.accountmicroservice.service.AccountService;
import com.aline.core.dto.response.AccountResponse;
import com.aline.core.model.account.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponse getAccountById(@PathVariable long id) {
        Account account = service.getAccountById(id);
        return service.mapToResponse(account);
    }

}
