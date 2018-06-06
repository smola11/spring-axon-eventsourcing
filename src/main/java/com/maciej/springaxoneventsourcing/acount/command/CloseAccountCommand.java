package com.maciej.springaxoneventsourcing.acount.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CloseAccountCommand {

    public CloseAccountCommand(String id) {
        this.id = id;
    }

    @TargetAggregateIdentifier
    public final String id;

}
