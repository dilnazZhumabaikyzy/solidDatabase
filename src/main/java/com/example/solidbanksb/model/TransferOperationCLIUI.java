package com.example.solidbanksb.model;

import com.example.solidbanksb.model.TransactionTransfer.TransferResult;
import com.example.solidbanksb.model.TransactionTransfer.TransferType;

public interface TransferOperationCLIUI {
    TransferResult processTransferType(TransferType transferType, String clientId);

    TransferType requestTransferType(int transferOption);
}
