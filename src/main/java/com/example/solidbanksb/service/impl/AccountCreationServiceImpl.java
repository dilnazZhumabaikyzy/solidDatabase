package com.example.solidbanksb.service.impl;

import com.example.solidbanksb.DAO.AccountDao;
import com.example.solidbanksb.model.*;
import com.example.solidbanksb.service.AccountCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {
    @Autowired
    AccountDao accountDao;
    @Override
    public void create(AccountType accountType, long bankId, String clientId, String accountId) {
        switch (accountType){
            case CHECKING -> accountDao.createNewAccount(new CheckingAccount(accountType, accountId, clientId, 0.0, true));
            case FIXED -> accountDao.createNewAccount(new FixedAccount(accountType, accountId, clientId, 0.0, false));
            case SAVING -> accountDao.createNewAccount(new SavingAccount(accountType, accountId, clientId, 0.0, true));
            default -> System.out.println("Wrong Input");
        }
    }
}
