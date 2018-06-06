package com.maciej.springaxoneventsourcing.acount;

import org.axonframework.commandhandling.model.AggregateIdentifier;

import java.io.Serializable;

public class BankAcoount implements Serializable {

    private static final long serialVersionUID = 1L;

    @AggregateIdentifier
    private String id;

    private double balance;
    private String owner;
}
