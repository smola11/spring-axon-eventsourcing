package com.maciej.springaxoneventsourcing.acount.command;

import com.maciej.springaxoneventsourcing.BaseCommand;

public class CloseAccountCommand extends BaseCommand<String> {

    public CloseAccountCommand(String id) {
        super(id);
    }
}
