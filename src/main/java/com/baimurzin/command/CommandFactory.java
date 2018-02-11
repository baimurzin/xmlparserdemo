package com.baimurzin.command;

import com.baimurzin.command.impl.CommandRegistryImpl;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommandFactory {

    private static CommandFactory instance;
    private CommandRegistry commandRegistry = CommandRegistryImpl.getInstance();

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    private Command getCommand(Option option) {
        if (commandRegistry.hasRegisteredCommand(option.getLongOpt())) {
            return commandRegistry.getRegisteredCommand(option.getLongOpt());
        } else if (commandRegistry.hasRegisteredCommand(option.getOpt())) {
            return commandRegistry.getRegisteredCommand(option.getOpt());
        }
        throw new IllegalArgumentException("No commands found");
    }

    public List<Command> getCommands(CommandLine cmd) {
        Set<String> appCommands = commandRegistry.getRegisteredCommandsName();
        List<Option> userArgs = Arrays.stream(cmd.getOptions())
                .filter(option -> appCommands.contains(option.getLongOpt()) || appCommands.contains(option.getOpt()))
                .collect(Collectors.toList());

        return userArgs.stream().map(option -> {
            Command command = getCommand(option);
            command.parseArguments(cmd.getOptions());
            return command;
        }).collect(Collectors.toList());
    }
}
