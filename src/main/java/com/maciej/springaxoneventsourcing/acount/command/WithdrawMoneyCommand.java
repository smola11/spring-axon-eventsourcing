package com.maciej.springaxoneventsourcing.acount.command;

import com.maciej.springaxoneventsourcing.BaseCommand;

public class WithdrawMoneyCommand extends BaseCommand<String> {

    public WithdrawMoneyCommand(String id, double amount) {
        super(id);
        this.amount = amount;
    }

    public final double amount;
}
