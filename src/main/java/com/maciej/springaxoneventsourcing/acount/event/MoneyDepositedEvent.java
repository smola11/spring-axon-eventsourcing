package com.maciej.springaxoneventsourcing.acount.event;

import com.maciej.springaxoneventsourcing.BaseEvent;

public class MoneyDepositedEvent extends BaseEvent<String> {

    public MoneyDepositedEvent(String id, double amount) {
        super(id);
        this.amount = amount;
    }

    public final double amount;
}
