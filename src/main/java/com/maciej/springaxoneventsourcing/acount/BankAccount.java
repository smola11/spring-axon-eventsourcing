package com.maciej.springaxoneventsourcing.acount;

import com.maciej.springaxoneventsourcing.acount.command.CloseAccountCommand;
import com.maciej.springaxoneventsourcing.acount.command.CreateAccountCommand;
import com.maciej.springaxoneventsourcing.acount.command.DepositMoneyCommand;
import com.maciej.springaxoneventsourcing.acount.command.WithdrawMoneyCommand;
import com.maciej.springaxoneventsourcing.acount.event.AccountClosedEvent;
import com.maciej.springaxoneventsourcing.acount.event.AccountCreatedEvent;
import com.maciej.springaxoneventsourcing.acount.event.MoneyDepositedEvent;
import com.maciej.springaxoneventsourcing.acount.event.MoneyWithdrawnEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import java.io.Serializable;

@Aggregate
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    public BankAccount() {
    }

    @AggregateIdentifier
    private String id;

    private double balance;
    private String owner;

    @CommandHandler
    public BankAccount(CreateAccountCommand command) {
        String id = command.id;
        String creator = command.accountCreator;

        // Validation of Command
        Assert.hasLength(id, "Missing id");
        Assert.hasLength(creator, "Missing account creator");

        // Event is published
        AggregateLifecycle.apply(new AccountCreatedEvent(id, creator, 0));
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent event) {
        this.id = event.id;
        this.owner = event.accountCreator;
        this.balance = event.balance;
    }

    @CommandHandler
    protected void on(DepositMoneyCommand command) {
        double amount = command.amount;

        Assert.isTrue(amount > 0.0, "Deposit must be a positive number.");

        AggregateLifecycle.apply(new MoneyDepositedEvent(id, amount));
    }

    @EventSourcingHandler
    protected void on(MoneyDepositedEvent event) {
        this.balance += event.amount;
    }

    @CommandHandler
    protected void on(WithdrawMoneyCommand command) {
        double amount = command.amount;

        Assert.isTrue(amount > 0.0, "Withdraw must be a positive number.");

        if (balance - amount < 0) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }

        AggregateLifecycle.apply(new MoneyWithdrawnEvent(id, amount));
    }

    public static class InsufficientBalanceException extends RuntimeException {
        InsufficientBalanceException(String message) {
            super(message);
        }
    }

    @EventSourcingHandler
    protected void on(MoneyWithdrawnEvent event) {
        this.balance -= event.amount;
    }

    @CommandHandler
    protected void on(CloseAccountCommand command) {
        AggregateLifecycle.apply(new AccountClosedEvent(command.id));
    }

    @EventSourcingHandler
    protected void on(AccountClosedEvent event) {
        AggregateLifecycle.markDeleted();
    }
}
