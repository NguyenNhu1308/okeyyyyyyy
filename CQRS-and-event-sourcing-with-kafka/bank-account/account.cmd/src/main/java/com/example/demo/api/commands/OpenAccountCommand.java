package com.example.demo.api.commands;

import com.example.demo.commands.BaseCommand;
import com.example.demo.dto.AccountType;
import lombok.Data;

@Data
public class OpenAccountCommand extends BaseCommand {
    private String accountHolder;
    private AccountType accountType;
    private double openingBalance;
}
