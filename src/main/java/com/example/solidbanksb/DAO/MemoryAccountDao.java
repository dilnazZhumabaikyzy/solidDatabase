package com.example.solidbanksb.DAO;

import com.example.solidbanksb.model.Account;
import com.example.solidbanksb.model.AccountType;
import com.example.solidbanksb.model.AccountWithdraw;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

        List<Account> filteredAccounts = accountList.stream()
                .filter(account -> account.getClientId().equals(clientId) && account.getAccountType().equals(accountType))
                .toList();

        if (filteredAccounts.isEmpty()) {
            throw new NoSuchElementException("No accounts found for client " + clientId + " with account type " + accountType);
        }

        return filteredAccounts;
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
