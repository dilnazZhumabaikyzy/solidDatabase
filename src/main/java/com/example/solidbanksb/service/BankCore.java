package com.example.solidbanksb.service;

import com.example.solidbanksb.model.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    AccountCreationService accountCreationService;

    @Autowired
    public BankCore(AccountCreationService accountCreationService) {
        this.accountCreationService = accountCreationService;
    }

    public void createNewAccount(AccountType accountType, String clientId){
        accountCreationService.create(accountType, id, clientId, String.valueOf(lastAccountNumber));
        incrementLastAccountNumber();
    }

    private void incrementLastAccountNumber(){
        lastAccountNumber++;
    }
}
