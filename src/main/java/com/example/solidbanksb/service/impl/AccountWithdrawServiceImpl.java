package com.example.solidbanksb.service.impl;

import com.example.solidbanksb.DAO.AccountDao;
import com.example.solidbanksb.model.Account.Account;
import com.example.solidbanksb.service.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void withdraw(double amount, Account account) throws Exception {
        double newBalance = account.getBalance() - amount;
        if(newBalance < 0){
           throw new Exception("Unable to complete the withdrawal operation. Account balance is too low.");
        }
        account.setBalance(newBalance);
    }
}
