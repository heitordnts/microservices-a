package com.fullcycle.balance;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullcycle.balance.entity.Account;
import com.fullcycle.balance.service.BalanceService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@SpringBootApplication
@RestController()
@RequestMapping("/balances")
public class BalanceApplication {
	@Autowired
	private BalanceService balanceService;

	public static void main(String[] args) {
		SpringApplication.run(BalanceApplication.class, args);
	}

	// {"account_id_from":"30cc6a11-96ec-4171-9ac2-812e6bb2cf8d",
	//"account_id_to":"db8654e3-f0aa-416a-b796-4e68f9b9aa78","balance_account_id_from":85,"balance_account_id_to":15}
	@KafkaListener(topics = "balances", groupId = "wallet")
	public void listenGroupFoo(String message) {
		Gson gson = new Gson();

		JsonObject msgJson = gson.fromJson(message, JsonObject.class);
		JsonObject payload = msgJson.get("Payload").getAsJsonObject();
		String accountFromId = payload.get("account_id_from").getAsString();
		String accountToId = payload.get("account_id_to").getAsString();
		Float balanceFrom = payload.get("balance_account_id_from").getAsFloat();
		Float balanceTo = payload.get("balance_account_id_to").getAsFloat();

		Optional<Account> accountById = balanceService.getAccountById(accountFromId);

		if(!accountById.isPresent()){
			Account newAccount = new Account();
			newAccount.setId(accountFromId);
			newAccount.setBalance(balanceFrom);
			balanceService.createAccount(newAccount);
		}else{
			accountById.get().setBalance(balanceFrom);
			balanceService.updateAccount(accountFromId, accountById.get());
		}

		accountById = balanceService.getAccountById(accountToId);

		if(!accountById.isPresent()){
			Account newAccount = new Account();
			newAccount.setId(accountToId);
			newAccount.setBalance(balanceTo);
			balanceService.createAccount(newAccount);
		}else{
			accountById.get().setBalance(balanceTo);
			balanceService.updateAccount(accountToId, accountById.get());
		}

		System.out.println("Received Message in group foo: " + message);
	}

}
