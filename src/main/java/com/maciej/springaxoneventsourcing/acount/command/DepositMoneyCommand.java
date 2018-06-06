package com.maciej.springaxoneventsourcing.acount.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class DepositMoneyCommand {

    public DepositMoneyCommand(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    @TargetAggregateIdentifier
    public final String id;
    public final double amount;

}
