package com.example.solidbanksb.model.Account;

import com.example.solidbanksb.model.Account.AccountType;
import com.example.solidbanksb.model.TransactionWithdraw.AccountWithdraw;
public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}
