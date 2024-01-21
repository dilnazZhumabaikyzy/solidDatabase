package com.example.solidbanksb.service;

import com.example.solidbanksb.model.Account.Account;
import com.example.solidbanksb.model.TransactionWithdraw.AccountWithdraw;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
