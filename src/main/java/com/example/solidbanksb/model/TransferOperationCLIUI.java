package com.example.solidbanksb.model;

public interface TransferOperationCLIUI {
    TransferResult processTransferType(TransferType transferType, String clientId);

    TransferType requestTransferType(int transferOption);
}
