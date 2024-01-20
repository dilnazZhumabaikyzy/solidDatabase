package com.example.solidbanksb.DAO;

import com.example.solidbanksb.model.Account;
import com.example.solidbanksb.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryTransactionDao implements TransactionDao{

    List<Transaction> transactions = new ArrayList<>();

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
