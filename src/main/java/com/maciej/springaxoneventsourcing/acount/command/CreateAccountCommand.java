package com.maciej.springaxoneventsourcing.acount.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateAccountCommand {

    public CreateAccountCommand(String id, String accountCreator) {
        this.id = id;
        this.accountCreator = accountCreator;
    }

    @TargetAggregateIdentifier
    public final String id; // BankAccount id;
    public final String accountCreator;


}
