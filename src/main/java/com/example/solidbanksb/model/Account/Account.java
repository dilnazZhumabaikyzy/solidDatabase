package com.example.solidbanksb.model.Account;

//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {

    private AccountType accountType;

    @GeneratedValue
    private @Id String id;

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
