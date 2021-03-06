package com.baimurzin.command;

import java.util.Collection;
import java.util.Set;

public interface CommandRegistry {

    void register(Command command);
    boolean remove(Command command);
    Collection<Command> getRegisteredCommands();
    Command getRegisteredCommand(String commandIdentifier);
    boolean hasRegisteredCommand(String commandIdentifier);
    public Set<String> getRegisteredCommandsName();
}
