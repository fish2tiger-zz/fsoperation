package com.salesforce.tests.fs.model;

import java.util.Set;

public class FileSystem {
    private Directory currentDirectory;

    private FileSystem() {
        this.currentDirectory = new Directory(null, "root");
    }

    public Set<String> dir() {
        return currentDirectory.getDirnames();
    }

    public boolean createDirectory(String dirname) {
        return currentDirectory.createDir(dirname);
    }

    public boolean up() {
        if (currentDirectory.up() == null) {
//            logger.error("directory: " + currentDirectory.getName() + " doesn't have parent!");
            return false;
        }
        this.currentDirectory = currentDirectory.up();
        return true;
    }

    public boolean cd(String directory) {
        Directory gotoDir = currentDirectory.getSubDir(directory);
        if (gotoDir != null) {
            this.currentDirectory = gotoDir;
            return true;
        }
        return false;
    }

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    static public FileSystem getFs() {
        return new FileSystem();
    }
}
