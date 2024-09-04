package com.fullcycle.balance.service;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullcycle.balance.entity.Account;
import com.fullcycle.balance.repository.AccountRepositoryInterface;

import java.util.Optional;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private AccountRepositoryInterface accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getAccountById(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account updateAccount(String id, Account account) {
        if (!accountRepository.existsById(id)) {
            throw new ResourceNotFoundException("Account with ID " + id + " not found");
        }
        account.setId(id);
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String id) {
        if (!accountRepository.existsById(id)) {
            throw new ResourceNotFoundException("Account with ID " + id + " not found");
        }
        accountRepository.deleteById(id);
    }

     @Override
    public Optional<Double> getAccountBalanceById(String id) {
        return accountRepository.findById(id).map(Account::getBalance);
    }

}

