package com.example.solidbanksb.model.Account;

import com.example.solidbanksb.model.Account.AccountType;
import com.example.solidbanksb.model.TransactionDeposit.AccountDeposit;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}
