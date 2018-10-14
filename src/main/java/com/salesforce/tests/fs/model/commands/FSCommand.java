package com.salesforce.tests.fs.model.commands;

import com.salesforce.tests.fs.model.FileSystem;

public abstract class FSCommand {
    private String opname;
    private String argument;

    FSCommand(String opname, String argument) {
        this.opname = opname;
        this.argument = argument;
    }

    public String getFormatedOutput() {
        return String.format("Command: %-8s%s\n", opname, argument == null ? "" : argument);
    }

    public abstract String[] execute(FileSystem fs);

    String getOpname() {
        return opname;
    }

    String getArgument() {
        return argument;
    }
}
