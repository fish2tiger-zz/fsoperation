package com.salesforce.tests.fs.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Directory {
    private static final Logger logger = LogManager.getLogger(Directory.class);
    private Directory parentDir;
    private List<Directory> subdirs;
    private String name;
    private Set<String> dirnames;

    public Directory(Directory parent, String dirname){
        this.parentDir = parent;
        this.name = dirname;
        this.subdirs = new ArrayList<>();
        this.dirnames = new HashSet<>();
    }
    public String getName(){
        return this.name;
    }

    public List<Directory> getdirs() {
        return subdirs;
    }

    public boolean hasDir(String dirName){
        if(dirName.contains(dirName)){
            return true;
        }
        return false;
    }


    public Set<String> getDirnames(){
        return dirnames;
    }
    public boolean createDir(String dirname) {

        if(!dirnames.contains(dirname)){
            Directory newdir = new Directory(this, dirname);
            subdirs.add(newdir);
            dirnames.add(dirname);
            return true;
        }
        return false;
    }
    public Directory up(){
        return this.parentDir;
    }

    public Directory getSubDir(String directory) {
        if(dirnames.contains(directory)){
            for(Directory dir : subdirs){
                if(dir.getName().equals(directory))
                    return dir;
            }
        }
        return null;
    }
    public List<String> getPath(){
        Deque<String> path = new ArrayDeque<>();
        Directory dir = this;
        while(dir!=null){
            path.offerFirst(dir.name);
            dir = dir.parentDir;
        }
        List<String> list = new ArrayList<>();

        path.forEach(c-> list.add(c));
        return list;
    }
    public String getPathStr(){
        Deque<String> path = new ArrayDeque<>();
        Directory dir = this;
        while(dir!=null){
            path.offerFirst(dir.name);
            dir = dir.parentDir;
        }
        StringBuilder builder = new StringBuilder();

        while(path.size()>0){
            if(path.size()==1 ){
                builder.append(path.pollFirst());
            }else{
                builder.append(path.pollFirst()).append("\\");
            }
        }
        return builder.toString();
    }
}
