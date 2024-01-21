package com.example.solidbanksb.model.Account;
import com.example.solidbanksb.model.TransactionWithdraw.AccountWithdraw;
import com.example.solidbanksb.model.Account.AccountType;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}
