package com.example.solidbanksb.model;

public interface CLIUI extends CreateAccountOperationUI, WithdrawDepositOperationCLIUI, TransferOperationCLIUI {
    int chooseTheOption();
}
