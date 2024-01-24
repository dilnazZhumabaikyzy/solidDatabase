package com.example.solidbanksb.service;


import com.example.solidbanksb.model.Account.AccountType;


public interface AccountCreationService {
    void create(String accountId, AccountType accountType, String clientId);
}
