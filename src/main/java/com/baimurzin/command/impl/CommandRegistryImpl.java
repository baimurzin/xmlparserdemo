package com.baimurzin.command.impl;

import com.baimurzin.command.Command;
import com.baimurzin.command.CommandRegistry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandRegistryImpl implements CommandRegistry {

    private final Map<String, Command> commandRegistryMap = new HashMap<>();

    private static CommandRegistry instance;

    private CommandRegistryImpl() {

    }

    public static CommandRegistry getInstance() {
        if (instance == null) {
            instance = new CommandRegistryImpl();
        }
        return instance;
    }

    @Override
    public void register(Command command) {
        if (commandRegistryMap.containsKey(command.getCommandIdentifier())) {
            throw new IllegalArgumentException("Command already exists");
        }
        commandRegistryMap.put(command.getCommandIdentifier(), command);
    }

    @Override
    public boolean remove(Command command) {
        if (commandRegistryMap.containsKey(command.getCommandIdentifier())) {
            commandRegistryMap.remove(command.getCommandIdentifier());
            return true;
        }
        return false;
    }

    @Override
    public Collection<Command> getRegisteredCommands() {
        return commandRegistryMap.values();
    }

    @Override
    public Command getRegisteredCommand(String commandIdentifier) {
        return commandRegistryMap.get(commandIdentifier);
    }

    @Override
    public boolean hasRegisteredCommand(String commandIdentifier) {
        return commandRegistryMap.containsKey(commandIdentifier);
    }

    public Set<String> getRegisteredCommandsName() {
        return commandRegistryMap.keySet();
    }
}