package com.example.solidbanksb.model.TransactionTransfer;

import com.example.solidbanksb.model.Account.Account;
import com.example.solidbanksb.model.Account.AccountType;
import com.example.solidbanksb.model.TransferOperationCLIUI;
import com.example.solidbanksb.service.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@AllArgsConstructor
@Component
public class TransactionTransferCLI {

    @Autowired
    TransferOperationCLIUI transferOperationCLIUI;
    @Autowired
    AccountListingService accountListingService;
    @Autowired
    TransactionTransfer transactionTransfer;


    public void transfer(double transferAmount, AccountType fromAccountType, String fromAccountNumber, String clientId, AccountType toAccountType, String toAccountNumber, String toClientId, TransferType transferType) throws Exception {
        if(!Objects.equals(clientId, toClientId))
            transferAmount *= 1.15;

        if(transferType.equals(TransferType.TRANSFER_BETWEEN_OWN_ACCOUNTS)){
            List<Account> fromAccounts = accountListingService.getClientAccountsByType(clientId,fromAccountType);

            Account fromAccount = fromAccounts.stream()
                    .filter(acc -> acc.getId().equals(fromAccountNumber))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Account not found: " + fromAccountNumber));

            List<Account> toAccounts = accountListingService.getClientAccountsByType(toClientId,toAccountType);

            Account toAccount = toAccounts.stream()
                    .filter(acc -> acc.getId().equals(toAccountNumber))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Account not found: " + toAccountNumber));

            transactionTransfer.execute(fromAccount, toAccount, transferAmount);

        }

    }
}
