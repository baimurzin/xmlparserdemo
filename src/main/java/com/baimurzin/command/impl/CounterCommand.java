package com.baimurzin.command.impl;

import com.baimurzin.command.Command;
import com.baimurzin.service.impl.XMLElementCounterServiceImpl;
import org.apache.commons.cli.Option;

import java.util.Arrays;
import java.util.Set;

public class CounterCommand extends AbstractCommand implements Command {

    private String commandIdentifier = "c";
    private String description = "Count element in given xml";

    public CounterCommand() {
        this.options.add(new Option(this.getCommandIdentifier(), true, this.getCommandDescription()));
        requiredOptions.add("xml");
        this.service = new XMLElementCounterServiceImpl();
    }

    @Override
    public String getCommandIdentifier() {
        return this.commandIdentifier;
    }

    public Set<Option> getOptions() {
        return options;
    }

    @Override
    public Object execute() {
        return service.apply(parameters);
    }

    @Override
    public void addParameter(String paramName, String value) {
        parameters.put(paramName, value);
    }

    @Override
    public String getCommandDescription() {
        return this.description;
    }

    @Override
    public Set<String> getRequiredOptions() {
        return this.requiredOptions;
    }
    @Override
    public void parseArguments(Option[] options) {
        Arrays.stream(options)
                .filter(option -> requiredOptions.contains(option.getOpt())
                        || requiredOptions.contains(option.getLongOpt())
                        || option.hasArg())
                .forEach(option -> addParameter(option.getOpt(), option.getValue()));
    }

}
