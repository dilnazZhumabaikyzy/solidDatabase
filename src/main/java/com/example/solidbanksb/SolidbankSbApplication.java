package com.example.solidbanksb;

import com.example.solidbanksb.model.Account.AccountBasicCli;
import com.example.solidbanksb.model.Account.AccountType;
import com.example.solidbanksb.model.TransactionDeposit.TransactionDepositCLI;
import com.example.solidbanksb.model.TransactionTransfer.TransactionTransferCLI;
import com.example.solidbanksb.model.TransactionTransfer.TransferResult;
import com.example.solidbanksb.model.TransactionTransfer.TransferType;
import com.example.solidbanksb.model.TransactionWithdraw.TransactionWithdrawCLI;
import com.example.solidbanksb.service.MyCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class SolidbankSbApplication  implements CommandLineRunner {

    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SolidbankSbApplication.class);
    }

    @Override
    public void run(String... arg0) throws Exception {
        boolean running = true;
        String clientId = "1";

        String helpMessage = "1 - showAccounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit\n";
        System.out.println("Welcome to CLIBank!");
        System.out.println(helpMessage);
        System.out.println("Please enter the command number:");
        while (running){
            try {
                AccountBasicCli accountBasicCli = context.getBean(AccountBasicCli.class);
                TransactionDepositCLI  transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
                TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);
                TransactionTransferCLI transactionTransferCLI = context.getBean(TransactionTransferCLI.class);
                MyCLI myCLI = context.getBean(MyCLI.class);
                switch (myCLI.getScanner().nextLine()){
                    case "1":
                        accountBasicCli.getAccounts(clientId);
                        break;
                    case "2":
                        System.out.println("Choose account type: [CHECKING, SAVING, FIXED]");
                        accountBasicCli.createAccountRequest(myCLI.requestAccountType(), clientId);
                        break;
                    case "3":{
                        System.out.println("Which account to deposit to? [CHECKING, SAVING, FIXED] ");
                        AccountType accountTypeChoice = myCLI.requestAccountType();
                        System.out.println("Write account number:");
                        String accountNumber= myCLI.requestClientAccountNumber();
                        System.out.println("Write deposit amount: ");
                        double depositAmount = myCLI.requestClientAmount();
                        transactionDepositCLI.depositMoney(depositAmount, accountTypeChoice, accountNumber, clientId);
                        break;
                    }
                    case "4":
                        System.out.println("From which account withdraw? [CHECKING, SAVING, FIXED] ");
                        AccountType accountTypeChoice = myCLI.requestAccountType();
                        System.out.println("Write account number:");
                        String accountNumber= myCLI.requestClientAccountNumber();
                        System.out.println("Write withdraw amount: ");
                        double withdrawAmount = myCLI.requestClientAmount();
                        transactionWithdrawCLI.withdrawMoney(withdrawAmount, accountTypeChoice, accountNumber, clientId);
                        break;
                    case "5":{
                        System.out.println("Choose the option:");
                        System.out.println("1. Transfer to another client's account");
                        System.out.println("2. Transfer between own accounts");
                        int transferOption = myCLI.chooseTheOption();
                        TransferType transferType = myCLI.requestTransferType(transferOption);
                        System.out.println("From which account transfer to? [CHECKING, SAVING, FIXED] ");
                        AccountType fromAccountTypeChoice = myCLI.requestAccountType();
                        System.out.println("Write your account number:");
                        String fromAccountNumber= myCLI.requestClientAccountNumber();


                        TransferResult transferResult = myCLI.processTransferType(transferType, clientId);

                        System.out.println("Write transfer amount: ");
                        double transferAmount = myCLI.requestClientAmount();

                        transactionTransferCLI.transfer(transferAmount,
                                fromAccountTypeChoice,
                                fromAccountNumber,
                                clientId,
                                transferResult.getToAccountType(),
                                transferResult.getToAccountNumber(),
                                transferResult.getToClientId(),
                                transferType);
                        break;
                    }

                    case "6":
                        System.out.println(helpMessage);
                        break;
                    case "7":
                        running = false;
                        System.out.println("Exit");

                }
            }
            catch (Exception e){
                System.out.println("Wrong input: " + e.getMessage());
            }
        }
    }
}
