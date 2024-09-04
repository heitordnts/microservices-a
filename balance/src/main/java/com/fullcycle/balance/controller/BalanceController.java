package com.fullcycle.balance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fullcycle.balance.entity.Account;
import com.fullcycle.balance.repository.AccountRepositoryInterface;
import com.fullcycle.balance.service.BalanceService;

import java.util.Optional;

@RestController
@RequestMapping("/balances")
public class BalanceController {
     @Autowired
    private BalanceService balanceService;

    @GetMapping("/{account_id}")
    public ResponseEntity<Double> getBalanceById(@PathVariable String account_id) {
        Optional<Double> balance = balanceService.getAccountBalanceById(account_id);
        return balance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
