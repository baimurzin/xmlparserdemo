package com.baimurzin.command.impl;

import com.baimurzin.command.Command;
import com.baimurzin.service.impl.XMLValidationServiceImpl;
import org.apache.commons.cli.Option;

import java.util.Set;

public class ValidationCommand extends AbstractCommand implements Command {

    public ValidationCommand() {
        this.options.add(new Option("xsd", true, "Schema file path"));
        this.options.add(new Option("v", "Option to validate"));
        this.service = new XMLValidationServiceImpl();
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
}
