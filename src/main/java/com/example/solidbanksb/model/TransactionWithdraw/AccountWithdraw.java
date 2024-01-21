package com.example.solidbanksb.model.TransactionWithdraw;

import com.example.solidbanksb.model.Account.Account;
import com.example.solidbanksb.model.Account.AccountType;

public class AccountWithdraw extends Account {
    public AccountWithdraw(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}
