package com.maciej.springaxoneventsourcing.acount.event;

import com.maciej.springaxoneventsourcing.BaseEvent;

public class MoneyWithdrawnEvent extends BaseEvent<String> {

    public final double amount;

    public MoneyWithdrawnEvent(String id, double amount) {
        super(id);
        this.amount = amount;
    }
}
