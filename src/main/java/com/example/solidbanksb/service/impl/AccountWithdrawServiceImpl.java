package com.example.solidbanksb.service.impl;

import com.example.solidbanksb.DAO.AccountDao;
import com.example.solidbanksb.model.Account;
import com.example.solidbanksb.model.AccountWithdraw;
import com.example.solidbanksb.service.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void withdraw(double amount, Account account) {
        double newBalance = account.getBalance() - amount;
        if(newBalance < 0){
            System.out.println("Not enough money!");
            return;
        }
        account.setBalance(newBalance);
    }
}
