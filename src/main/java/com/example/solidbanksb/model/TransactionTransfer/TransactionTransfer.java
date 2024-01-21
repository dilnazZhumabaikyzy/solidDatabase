package com.example.solidbanksb.model.TransactionTransfer;

import com.example.solidbanksb.DAO.TransactionDao;
import com.example.solidbanksb.model.Account.Account;
import com.example.solidbanksb.model.Transaction.Transaction;
import com.example.solidbanksb.model.Transaction.TransactionType;
import com.example.solidbanksb.service.AccountDepositService;
import com.example.solidbanksb.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@AllArgsConstructor
@Component
public class TransactionTransfer {
    @Autowired
    TransactionDao transactionDao;

    @Autowired
    AccountDepositService accountDepositService;
    @Autowired
    AccountWithdrawService accountWithdrawService;


    public void execute(Account fromAccount, Account toAccount, double transferAmount) throws Exception {
        accountWithdrawService.withdraw(transferAmount, fromAccount);
        accountDepositService.deposit(transferAmount, toAccount);

        Transaction transaction = new Transaction(new Date(), TransactionType.TRANSFER, fromAccount);
        transactionDao.addTransaction(transaction);

        System.out.println("Transaction succesfully created");
        System.out.println("Info: " + transaction);
    }

}
