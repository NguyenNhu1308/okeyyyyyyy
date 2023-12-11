package com.example.demo.infrastructure.handlers;

import com.example.demo.domain.AccountRepository;
import com.example.demo.domain.BankAccount;
import com.example.demo.events.AccountClosedEvent;
import com.example.demo.events.AccountOpenedEvent;
import com.example.demo.events.FundsDepositedEvent;
import com.example.demo.events.FundsWithdrawnEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountEventHandler implements EventHandler {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void on(AccountOpenedEvent event) {
        var bankAccount = BankAccount.builder()
                .id(event.getId())
                .accountHolder(event.getAccountHolder())
                .creationDate(event.getCreatedDate())
                .accountType(event.getAccountType())
                .balance(event.getOpeningBalance())
                .build();
        accountRepository.save(bankAccount);
    }

    @Override
    public void on(FundsDepositedEvent event) {
        var bankAccount = accountRepository.findById(event.getId());
        if (bankAccount.isEmpty()) {
            return;
        }
        var currentBalance = bankAccount.get().getBalance();
        var latestBalance = currentBalance + event.getAmount();
        bankAccount.get().setBalance(latestBalance);
        accountRepository.save(bankAccount.get());
    }

    @Override
    public void on(FundsWithdrawnEvent event) {
        var bankAccount = accountRepository.findById(event.getId());
        if (bankAccount.isEmpty()) {
            return;
        }
        BankAccount newBankAccount = bankAccount.get();
        var currentBalance = newBankAccount.getBalance();
        var latestBalance = currentBalance - event.getAmount();
        newBankAccount.setBalance(latestBalance);
        accountRepository.save(newBankAccount);
    }

    @Override
    public void on(AccountClosedEvent event) {
        accountRepository.deleteById(event.getId());
    }
}
