package com.maciej.springaxoneventsourcing.acount.command;

import com.maciej.springaxoneventsourcing.BaseCommand;

public class DepositMoneyCommand extends BaseCommand<String> {

    public DepositMoneyCommand(String id, double amount) {
        super(id);
        this.amount = amount;
    }

    public final double amount;

}
