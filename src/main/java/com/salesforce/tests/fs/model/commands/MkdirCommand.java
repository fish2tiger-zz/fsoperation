package com.salesforce.tests.fs.model.commands;

import com.salesforce.tests.fs.model.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class MkdirCommand extends FSCommand {


    public MkdirCommand(String opname, String argument) {
        super(opname, argument);
    }

    @Override
    public String[] execute(FileSystem fs) {
        boolean created = fs.createDirectory(getArgument());
        List<String> list = new ArrayList<>();
        list.add(getFormatedOutput());
        if (!created)
            list.add("Subdirectory already exists\n");

        return list.toArray(new String[]{});
    }
}
