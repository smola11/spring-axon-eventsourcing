package com.maciej.springaxoneventsourcing.acount.event;

import com.maciej.springaxoneventsourcing.BaseEvent;

public class AccountClosedEvent extends BaseEvent<String> {
    public AccountClosedEvent(String id) {
        super(id);
    }

}
