package com.example.solidbanksb.service.impl;

import com.example.solidbanksb.DAO.AccountDao;
import com.example.solidbanksb.model.Account;
import com.example.solidbanksb.model.AccountWithdraw;
import com.example.solidbanksb.service.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public void deposit(double amount, Account account) {
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
    }
}
