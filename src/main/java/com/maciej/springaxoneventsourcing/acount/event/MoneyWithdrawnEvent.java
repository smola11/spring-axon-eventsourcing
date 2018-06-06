package com.maciej.springaxoneventsourcing.acount.event;

public class MoneyWithdrawnEvent {

    public final String id;
    public final double amount;

    public MoneyWithdrawnEvent(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }
}
