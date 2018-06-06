package com.maciej.springaxoneventsourcing.acount.event;

public class AccountCreatedEvent {

    public AccountCreatedEvent(String id, String accountCreator, double balance) {
        this.id = id;
        this.accountCreator = accountCreator;
        this.balance = balance;
    }

    public final String id;
    public final String accountCreator;
    public final double balance;

}
