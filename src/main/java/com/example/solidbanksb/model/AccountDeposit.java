package com.example.solidbanksb.model;

public class AccountDeposit extends Account{
    public AccountDeposit(){}

    public AccountDeposit(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}