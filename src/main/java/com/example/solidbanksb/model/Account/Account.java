package com.example.solidbanksb.model.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    private AccountType accountType;
    private String id;
    private String clientId;
    private double balance = 0;
    private boolean withdrawAllowed;

    public boolean isWithdrawAllowed() {
        return withdrawAllowed;
    }

    @Override
    public String toString() {
        return "\nAccount information \n" +
                " - accountType: " + accountType +
                " - id: " + String.format("%03d%06d\n", 1, Integer.parseInt(id)) +
                " - clientId: " + clientId + "\n"+
                " - balance: " + balance +  "\n"+
                " - withdrawAllowed=" + withdrawAllowed;
    }
}
