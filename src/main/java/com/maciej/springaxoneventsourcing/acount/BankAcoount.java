package com.maciej.springaxoneventsourcing.acount;

import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.io.Serializable;

@Aggregate
public class BankAcoount implements Serializable {

    private static final long serialVersionUID = 1L;

    @AggregateIdentifier
    private String id;

    private double balance;
    private String owner;
}
