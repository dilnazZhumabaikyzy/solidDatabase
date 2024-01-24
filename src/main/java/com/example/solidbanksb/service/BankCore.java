package com.example.solidbanksb.service;

import com.example.solidbanksb.model.Account.AccountRepository;
import com.example.solidbanksb.model.Account.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankCore {

    AccountCreationService accountCreationService;
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    public BankCore(AccountCreationService accountCreationService) {
        this.accountCreationService = accountCreationService;
    }

    public void createNewAccount( AccountType accountType, String clientId){
        String accountId = generateAccountId(clientId);
        System.out.println(accountId);
        accountCreationService.create(accountId, accountType, clientId);
    }

    public String generateAccountId(String clientId) {
        return String.format("%03d%06d", Long.parseLong(clientId), getLastAccountId() );
    }

    private int getLastAccountId() {
        double lastAccountId = accountRepository.getLastAccountId();
        System.out.println(lastAccountId);
        return ((int) lastAccountId + 1);
    }

    public int getLastAccountIdForClient(String clientId) {
        double lastAccountId = accountRepository.getLastAccountIdForClient(clientId);
        System.out.println(lastAccountId);
        return ((int) lastAccountId);
    }
}
