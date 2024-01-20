package com.example.solidbanksb.DAO;

import com.example.solidbanksb.model.Account;
import com.example.solidbanksb.model.AccountType;
import com.example.solidbanksb.model.AccountWithdraw;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryAccountDao implements AccountDao{
    List<Account> accountList = new ArrayList<>();
    @Override
    public List<Account> getClientAccounts(String clientId) {
        return accountList;
    }

    @Override
    public void createNewAccount(Account account) {
        accountList.add(account);
        System.out.println("Bank account created successfully");
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public List<Account> getClientAccountsByType(String clientId, AccountType accountType) {

        return accountList.stream()
                .filter(account -> account.getAccountType().equals(accountType))
                .toList();
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientId, String accountId) {
        return null;
    }

    @Override
    public Account getClientAccount(String clientId, String accountId) {
        return null;
    }
}
