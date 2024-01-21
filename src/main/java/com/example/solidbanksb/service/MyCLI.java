package com.example.solidbanksb.service;

import com.example.solidbanksb.model.Account.AccountType;
import com.example.solidbanksb.model.CLIUI;
import com.example.solidbanksb.model.TransactionTransfer.TransferResult;
import com.example.solidbanksb.model.TransactionTransfer.TransferType;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class MyCLI implements CLIUI {
    private Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public AccountType requestAccountType() {
        return AccountType.valueOf(scanner.nextLine());
    }
    @Override
    public double requestClientAmount(){
        return Double.parseDouble(scanner.nextLine());
    }

    @Override
    public String requestClientAccountNumber() {
        return scanner.nextLine();
    }

    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public int chooseTheOption() {
        return Integer.parseInt(scanner.nextLine());
    }


    @Override
    public TransferResult processTransferType(TransferType transferType, String clientId) {
        TransferResult transferResult = new TransferResult();
        switch (transferType){
            case TRANSFER_TO_ANOTHER_CLIENT_ACCOUNT -> {
                System.out.println("Write client accounts id transfer to");
                transferResult.setToClientId(scanner.nextLine());
                System.out.println("Write client accounts type transfer to");
                transferResult.setToAccountType(AccountType.valueOf(scanner.nextLine()));
                System.out.println("Write client accounts number transfer to");
                transferResult.setToAccountNumber(scanner.nextLine());
            }
            case TRANSFER_BETWEEN_OWN_ACCOUNTS -> {
                transferResult.setToClientId(clientId);
                System.out.println("Write accounts type transfer to");
                transferResult.setToAccountType(AccountType.valueOf(scanner.nextLine()));
                System.out.println("Write accounts number transfer to");
                transferResult.setToAccountNumber(scanner.nextLine());
            }
        }
        return transferResult;
    }

    @Override
    public TransferType requestTransferType(int option) {
        TransferType transferType = null;
        switch (option) {
            case 1: transferType = TransferType.TRANSFER_TO_ANOTHER_CLIENT_ACCOUNT;
            case 2: transferType = TransferType.TRANSFER_BETWEEN_OWN_ACCOUNTS;
        }

        return transferType;
    }
}