package com.salesforce.tests.fs.model.commands;

import com.salesforce.tests.fs.model.FileSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirCommand extends FSCommand {


    public DirCommand(String opname) {
        super(opname, "");
    }

    @Override
    public String[] execute(FileSystem fs) {

        List<String> results = new ArrayList<>();

        results.add(getFormatedOutput());
        results.add(("Directory of "+fs.getCurrentDirectory().getPathStr()+":\n"));

        List<String> dirs = new ArrayList<>(fs.dir());
        Collections.sort(dirs);
        if (dirs.size() == 0) {
            results.add("No subdirectories\n");
        } else {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < dirs.size(); i++) {
                System.out.println("-----"+String.format("%8s", dirs.get(i)));
                line.append(String.format("%-8s", dirs.get(i)));
                if ((i + 1) % 10 == 0) {
                    results.add(line.toString());
                    line = new StringBuilder();
                }
            }

            if(!line.toString().isEmpty())
                results.add(line.toString());


        }

        return results.toArray(new String[]{});

    }
}
