package com.example.solidbanksb.DAO;

import com.example.solidbanksb.model.Account;
import com.example.solidbanksb.model.Transaction;

import java.util.List;

public interface TransactionDao {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}
