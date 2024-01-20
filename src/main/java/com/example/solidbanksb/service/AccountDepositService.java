package com.example.solidbanksb.service;

import com.example.solidbanksb.model.Account;
import com.example.solidbanksb.model.AccountType;
import com.example.solidbanksb.model.AccountWithdraw;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
