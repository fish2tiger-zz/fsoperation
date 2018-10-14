package com.salesforce.tests.fs.model.commands;

import com.salesforce.tests.fs.model.FileSystem;

public class CdCommand extends FSCommand {

    public CdCommand(String opname, String argument) {
        super(opname, argument);
    }

    @Override
    public String[] execute(FileSystem fs) {
        fs.cd(getArgument());

        return new String[]{getFormatedOutput()};
    }
}
