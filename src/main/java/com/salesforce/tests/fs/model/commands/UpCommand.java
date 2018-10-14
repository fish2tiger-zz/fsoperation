package com.salesforce.tests.fs.model.commands;

import com.salesforce.tests.fs.model.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class UpCommand extends FSCommand {

    public UpCommand(String opname) {
        super(opname, null);
    }

    @Override
    public String[] execute(FileSystem fs) {
        boolean hasup = fs.up();

        List<String> list = new ArrayList<>();
        list.add(getFormatedOutput());
        if (!hasup)
            list.add("Cannot move up from root directory\n");
        return list.toArray(new String[]{});
    }
}
