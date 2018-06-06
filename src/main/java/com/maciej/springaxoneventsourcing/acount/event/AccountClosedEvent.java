package com.maciej.springaxoneventsourcing.acount.event;

public class AccountClosedEvent {
    public AccountClosedEvent(String id) {
        this.id = id;
    }

    public final String id;
}
