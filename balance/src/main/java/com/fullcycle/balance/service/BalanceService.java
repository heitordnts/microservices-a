package com.fullcycle.balance.service;

import java.util.Optional;

import com.fullcycle.balance.entity.Account;

public interface BalanceService {

    Account createAccount(Account account);

    Optional<Account> getAccountById(String id);

    Account updateAccount(String id, Account account);

    void deleteAccount(String id);

    public Optional<Double> getAccountBalanceById(String id);

}