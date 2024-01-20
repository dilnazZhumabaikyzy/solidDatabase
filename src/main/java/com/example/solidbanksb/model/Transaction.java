package com.example.solidbanksb.model;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Transaction {
    private Date date;
    private TransactionType transactionType;
    private Account account;

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", transactionType=" + transactionType +
                ", account=" + account +
                '}';
    }
}