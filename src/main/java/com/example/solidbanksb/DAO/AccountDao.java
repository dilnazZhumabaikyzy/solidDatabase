package com.example.solidbanksb.DAO;


import com.example.solidbanksb.model.Account;
import com.example.solidbanksb.model.AccountType;
import com.example.solidbanksb.model.AccountWithdraw;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface AccountDao {
    List<Account> getClientAccounts(String clientId);
    void createNewAccount(Account account);
    void updateAccount(Account account);

    List<Account> getClientAccountsByType(String clientId, AccountType accountType);
    AccountWithdraw getClientWithdrawAccount(String clientId, String accountId);
    Account getClientAccount(String clientId, String accountId);
}
