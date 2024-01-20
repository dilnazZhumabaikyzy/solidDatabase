package com.example.solidbanksb.model;

import com.example.solidbanksb.service.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Component
public class TransactionDepositCLI{
    @Autowired
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    @Autowired
    AccountListingService accountListingService;
    @Autowired
    TransactionDeposit transactionDeposit;

    public void depositMoney(double amount, AccountType accountTypeChoice, String accountNumber, String clientId) {
        List<Account> accounts = accountListingService.getClientAccountsByType(clientId,accountTypeChoice);
//      001000001
//        System.out.println("Accounts:  ");
//        System.out.println(accounts);
//        System.out.println("Account Number:  ");
//        System.out.println(accountNumber);
        Account account = accounts.stream()
                                            .filter(acc -> acc.getId().equals(accountNumber))
                                            .findFirst()
                                            .orElse(null);
//        System.out.println("Account:  ");
//        System.out.println(account);
        transactionDeposit.execute(account, amount);
    }
}
