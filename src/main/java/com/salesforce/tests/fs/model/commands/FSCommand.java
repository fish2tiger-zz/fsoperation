package com.salesforce.tests.fs.model.commands;

import com.salesforce.tests.fs.model.FileSystem;

public abstract class FSCommand {
    private String opname;
    private String argument;

    FSCommand(String opname, String argument) {
        this.opname = opname;
        this.argument = argument;
    }

    String getFormatedOutput() {
        if(argument==null|| argument.isEmpty())
            return String.format("Command: %-8s\n", opname, argument);
        return String.format("Command: %-8s%-8s\n", opname, argument);
    }

    public abstract String[] execute(FileSystem fs);

    String getArgument() {
        return argument;
    }
}
