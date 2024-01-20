package com.example.solidbanksb.model;


import com.example.solidbanksb.service.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class TransactionWithdrawCLI {

        @Autowired
        WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
        @Autowired
        AccountListingService accountListingService;
        @Autowired
        TransactionWithdraw transactionWithdraw;

        public void withdrawMoney(double amount, AccountType accountTypeChoice, String accountNumber, String clientId) {
        List<Account> accounts = accountListingService.getClientAccountsByType(clientId,accountTypeChoice);

        Account account = accounts.stream()
                .filter(acc -> acc.getId().equals(accountNumber))
                .findFirst()
                .orElse(null);

        transactionWithdraw.execute(account, amount);
    }

}
