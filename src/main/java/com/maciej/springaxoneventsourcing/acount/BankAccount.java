package com.maciej.springaxoneventsourcing.acount;

import com.maciej.springaxoneventsourcing.acount.command.CreateAccountCommand;
import com.maciej.springaxoneventsourcing.acount.event.AccountCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import java.io.Serializable;

@Aggregate
public class BankAcoount implements Serializable {

    private static final long serialVersionUID = 1L;

    @CommandHandler
    public BankAccount(CreateAccountCommand command) {
        String id = command.id;
        String creator = command.accountCreator;

        Assert.hasLength(id, "Missing id");
        Assert.hasLength(creator, "Missing account creator");

        AggregateLifecycle.apply(new AccountCreatedEvent(id, creator, 0));
    }

    @AggregateIdentifier
    private String id;

    private double balance;
    private String owner;
}
