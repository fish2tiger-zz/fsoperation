package com.salesforce.tests.fs;

import com.salesforce.tests.fs.model.commands.FSCommand;
import com.salesforce.tests.fs.model.FSCommandLiteral;
import com.salesforce.tests.fs.model.FileSystem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FSUtil {
    private static final Logger logger = LogManager.getLogger(FSUtil.class);
    private FileSystem fs = FileSystem.getFs();
    static public FSCommand parseCommand(String input) {
        String[] command_parsed = input.split("\\s+");
        if (command_parsed.length == 0) {
            logger.error("error in command parsing");
        }
        String command_op = command_parsed[0];

        if(command_op.equals(FSCommandLiteral.DIR.getName())){
            return FSCommandLiteral.DIR.getCommand();
        }
        else if(command_op.equals(FSCommandLiteral.UP.getName())){
            return FSCommandLiteral.UP.getCommand();
        }
        else if(command_op.equals(FSCommandLiteral.MKDIR.getName())){
            String command_operand;
            if(command_parsed.length>1)
                command_operand = command_parsed[1];
            else{
                logger.error("Command "+ command_op+ " expects an argument");
                return null;
            }
            return FSCommandLiteral.MKDIR.getCommand(command_operand);
        }else if(command_op.equals(FSCommandLiteral.CD.getName())){
            String command_operand;
            if(command_parsed.length>1)
                command_operand = command_parsed[1];
            else{
                logger.error("Command "+ command_op+ " expects an argument");
                return null;
            }
            return FSCommandLiteral.CD.getCommand(command_operand);
        }
        return null;
    }
    public String[] execute(String input){
        FSCommand command = parseCommand(input);
        if(command==null){
            System.out.println("command is null: "+ input);
            return new String[]{"null comamnd"};
        }

        return command.execute(fs);
    }
}
