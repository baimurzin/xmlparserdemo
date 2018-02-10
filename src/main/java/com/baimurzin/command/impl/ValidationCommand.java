package com.baimurzin.command.impl;

import com.baimurzin.command.Command;
import com.baimurzin.service.impl.XMLValidationServiceImpl;
import org.apache.commons.cli.Option;

import java.util.Arrays;
import java.util.Set;

public class ValidationCommand extends AbstractCommand implements Command {

    private String commandIdentifier = "v";
    private String description = "Validate given xml";

    public ValidationCommand() {
        this.options.add(new Option("xsd", true, "Schema file path"));
        this.options.add(new Option("v", "Option to validate"));
        requiredOptions.add("xml");
        requiredOptions.add("xsd");
        this.service = new XMLValidationServiceImpl();
    }

    @Override
    public String getCommandIdentifier() {
        return this.commandIdentifier;
    }

    @Override
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
