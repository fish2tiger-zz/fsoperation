package com.salesforce.tests.fs.model;

import com.salesforce.tests.fs.model.commands.*;

public enum FSCommandLiteral {
    CD("cd"),
    UP("up"),
    DIR("dir"),
    MKDIR("mkdir");

    private String name;
    FSCommandLiteral(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public FSCommand getCommand(String arg){
        if("cd".equals(this.name))
            return new CdCommand("cd", arg);
        if("mkdir".equals(this.name))
            return new MkdirCommand("mkdir", arg);
        return null;
    }
    public FSCommand getCommand(){
        if("dir".equals(this.name))
            return new DirCommand("dir");
        if("up".equals(this.name))
            return new UpCommand("up");

        return null;
    }
}
