package com.example.solidbanksb.model;

import com.example.solidbanksb.DAO.TransactionDao;
import com.example.solidbanksb.service.AccountDepositService;
import com.example.solidbanksb.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@AllArgsConstructor
@Component
public class TransactionWithdraw {
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    AccountWithdrawService accountWithdrawService;
    public void execute(Account account, double amount){
        accountWithdrawService.withdraw(amount, account);

        Transaction transaction = new Transaction(new Date(),TransactionType.WITHDRAW, account);
        transactionDao.addTransaction(transaction);

        System.out.println("Transaction succesfully created");
        System.out.println("Info: " + transaction);
    }

}
