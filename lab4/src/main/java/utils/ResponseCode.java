package utils;

public enum ResponseCode {
    OK(200),
    BAD_REQUEST(400);

    private int commandIndex;

    ResponseCode(int commandIndex) {
        this.commandIndex = commandIndex;
    }

    public int getCommandIndex(){
        return this.commandIndex;
    }

    public static ResponseCode getCommandByIndex(int commandIndex){
        for (ResponseCode command : values()) {
            if (command.getCommandIndex() == commandIndex){
                return command;
            }
        }
        return BAD_REQUEST;
    }
    }