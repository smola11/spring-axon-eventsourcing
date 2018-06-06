package com.maciej.springaxoneventsourcing.acount.command;

import com.maciej.springaxoneventsourcing.BaseCommand;

public class CreateAccountCommand extends BaseCommand<String> {

    public CreateAccountCommand(String id, String accountCreator) {
        super(id);
        this.accountCreator = accountCreator;
    }

    public final String accountCreator;


}
