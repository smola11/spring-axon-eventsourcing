package com.maciej.springaxoneventsourcing.acount.event;

import com.maciej.springaxoneventsourcing.BaseEvent;

public class AccountCreatedEvent extends BaseEvent<String> {

    public AccountCreatedEvent(String id, String accountCreator, double balance) {
        super(id);
        this.accountCreator = accountCreator;
        this.balance = balance;
    }

    public final String accountCreator;
    public final double balance;

}
