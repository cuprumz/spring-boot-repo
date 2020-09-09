package io.github.cuprumz.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.github.cuprumz.model.Account;


public interface AccountRepository extends CrudRepository<Account, Long> {

    @Modifying
    @Query("update Account a set a.balance = :balance where a.id = :id")
    int updateBalanceById(@Param("balance") Float balance, @Param("id") Long id);
}