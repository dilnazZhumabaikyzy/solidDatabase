package com.example.solidbanksb.model;

import java.util.Date;

public enum TransferType {
    TRANSFER_TO_ANOTHER_CLIENT_ACCOUNT("TRANSFER_TO_ANOTHER_CLIENT"),
    TRANSFER_BETWEEN_OWN_ACCOUNTS("   TRANSFER_BETWEEN_OWN_ACCOUNTS");
    private String type;

    public String getType() {
        return type;
    }

    TransferType(String type){
        this.type = type;
    }
}
