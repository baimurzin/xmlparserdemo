package com.baimurzin.command;

import com.baimurzin.console.CommandLineBuilder;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommandFactory {

    private static CommandFactory instance;
    private List<Command> commands = new ArrayList<>();

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Set<Option> registerCommands(Command command) {
        commands.add(command);
        return command.getOptions();
    }

    //todo refactor, change method argument parsing
    public List<Command> getCommands(CommandLineBuilder commandLine) {
        CommandLine cmd = commandLine.getCmd();

        return commands.stream().filter(command -> {
            //java -jar app.jar -v -c -xml file.xml -xsd file.xsd -s
            List<String> args = command.getOptions().stream().map(Option::getOpt).collect(Collectors.toList());
            List<String> userArgs = Arrays.stream(cmd.getOptions()).map(option -> {
                if (option.hasArg()) {
                    command.addParameter(option.getOpt(), option.getValue());
                }
                return option.getOpt();
            }).collect(Collectors.toList());
//            if (userArgs.contains("s")) {
//                userArgs.remove("s");
//                //todo handle optional params
//            }
            return userArgs.containsAll(args);
        }).collect(Collectors.toList());
    }
}
