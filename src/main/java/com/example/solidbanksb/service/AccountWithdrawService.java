package com.example.solidbanksb.service;


import com.example.solidbanksb.model.Account.Account;

public interface AccountWithdrawService {
    void withdraw(double amount, Account account) throws Exception;
}
