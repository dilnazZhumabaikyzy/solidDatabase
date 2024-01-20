package com.example.solidbanksb.model;

import com.example.solidbanksb.DAO.TransactionDao;
import com.example.solidbanksb.service.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
@AllArgsConstructor
public class TransactionDeposit {

    @Autowired
    TransactionDao transactionDao;
    @Autowired
    AccountDepositService accountDepositService;
    public void execute(Account account, double amount){
        accountDepositService.deposit(amount, account);

        Transaction transaction = new Transaction(new Date(),TransactionType.DEPOSIT, account);
        transactionDao.addTransaction(transaction);

        System.out.println("Transaction succesfully created");
        System.out.println("Info: " + transaction);
    }

}

