package com.example.solidbanksb;

import com.example.solidbanksb.DAO.AccountDao;
import com.example.solidbanksb.DAO.MemoryAccountDao;
import com.example.solidbanksb.DAO.MemoryTransactionDao;
import com.example.solidbanksb.DAO.TransactionDao;
import com.example.solidbanksb.model.CreateAccountOperationUI;
import com.example.solidbanksb.model.TransactionDeposit;
import com.example.solidbanksb.model.TransactionDepositCLI;
import com.example.solidbanksb.model.WithdrawDepositOperationCLIUI;
import com.example.solidbanksb.service.AccountDepositService;
import com.example.solidbanksb.service.MyCLI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.solidbanksb"})
public class ApplicationConfig {
//    @Bean
//    public AccountDao accountDao(){
//        return new MemoryAccountDao();
//    }

//    @Bean
//    public CreateAccountOperationUI createAccountOperationUI(){
//        return new MyCLI();
//    }
//    @Bean
//    public WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI(){return new MyCLI();}

//    @Bean
//    public TransactionDao transactionDao(){return new MemoryTransactionDao();}

}
