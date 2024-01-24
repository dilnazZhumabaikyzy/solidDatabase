package com.example.solidbanksb.model.Account;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT * FROM account WHERE client_id = :client_id AND accountType = :accountType")
    List<Account> findByClientIdAndAccountType(@Param("client_id") String client_id, @Param("accountType") AccountType accountType);

    @Query("SELECT * FROM account WHERE client_id = :client_id AND accountId = :accountId")
    Account findByClientIdAndAccountId(@Param("client_id") String client_id, @Param("accountId") String accountId);

    List<Account> findByClientId(String client_id);

    @Query("SELECT MAX(CAST(SUBSTR(id,5) AS DECIMAL)) FROM account WHERE client_id = :client_id")
    Double getLastAccountIdForClient(@Param("client_id") String client_id);

    @Query("SELECT MAX(CAST(SUBSTR(id,5) AS DECIMAL)) FROM account")
    double getLastAccountId();

}