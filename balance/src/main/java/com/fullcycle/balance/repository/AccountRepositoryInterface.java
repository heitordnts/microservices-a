package com.fullcycle.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullcycle.balance.entity.Account;


@Repository
public interface AccountRepositoryInterface extends JpaRepository<Account, String>{
    //public Optional<Account> findById(String id);
}
