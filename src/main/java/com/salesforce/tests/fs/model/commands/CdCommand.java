package com.salesforce.tests.fs.model.commands;

import com.salesforce.tests.fs.model.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class CdCommand extends FSCommand {

    public CdCommand(String opname, String argument) {
        super(opname, argument);
    }

    @Override
    public String[] execute(FileSystem fs) {
        boolean dirchanged = fs.cd(getArgument());
        List<String> result = new ArrayList<>();
        result.add(getFormatedOutput());
        if(!dirchanged)
            result.add("Subdirectory does not exist\n");
        return result.toArray(new String[]{});
    }
}
