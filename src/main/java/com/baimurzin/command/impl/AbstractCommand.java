package com.baimurzin.command.impl;

import com.baimurzin.command.Command;
import com.baimurzin.output.Response;
import com.baimurzin.service.XmlService;
import org.apache.commons.cli.Option;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractCommand implements Command {

    protected Set<Option> options = new HashSet<>();
    protected Set<String> requiredOptions = new HashSet<>();
    protected HashMap<String, String> parameters = new HashMap<>();
    protected XmlService service;
    protected String commandIdentifier;
    protected String description;

    public AbstractCommand() {
        Option xmlOption = new Option("xml", true, "Xml file path");
        xmlOption.setRequired(true);
        this.options.add(xmlOption);
    }

    @Override
    public Response execute() {
        Response response = new Response();
        response.setData(service.apply(parameters));
        return response;
    }

    @Override
    public void addParameter(String paramName, String value) {
        parameters.put(paramName, value);
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

    @Override
    public Set<Option> getOptions() {
        return this.options;
    }

    @Override
    public String getCommandIdentifier() {
        return this.commandIdentifier;
    }

    @Override
    public String getCommandDescription() {
        return this.description;
    }
}
