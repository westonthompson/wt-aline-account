package com.aline.accountmicroservice.controller;

import com.aline.accountmicroservice.service.AccountService;
import com.aline.core.dto.response.AccountResponse;
import com.aline.core.model.account.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @GetMapping(value = "accounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public AccountResponse getAccountById(@PathVariable long id) {
        Account account = service.getAccountById(id);
        return service.mapToResponse(account);
    }

    @GetMapping(value = "/members/membership-id/{membershipId}/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<AccountResponse> getAccountsByMembershipId(@PathVariable String membershipId) {
        List<Account> accounts = service.getAccountsByMember(membershipId);
        return accounts.stream()
                .map(service::mapToResponse)
                .collect(Collectors.toList());
    }

}
