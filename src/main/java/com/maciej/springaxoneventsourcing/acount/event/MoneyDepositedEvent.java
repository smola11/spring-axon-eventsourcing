package com.maciej.springaxoneventsourcing.acount.event;

public class MoneyDepositedEvent {

    public MoneyDepositedEvent(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public final String id;
    public final double amount;
}
