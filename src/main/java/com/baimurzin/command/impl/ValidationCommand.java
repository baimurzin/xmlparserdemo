package com.baimurzin.command.impl;

import com.baimurzin.command.Command;
import com.baimurzin.output.Response;
import com.baimurzin.service.impl.XMLValidationServiceImpl;
import org.apache.commons.cli.Option;

import java.util.Arrays;
import java.util.Set;

public class ValidationCommand extends AbstractCommand implements Command {

    public ValidationCommand() {
        this.options.add(new Option("xsd", true, "Schema file path"));
        this.options.add(new Option("v", "Option to validate"));
        this.service = new XMLValidationServiceImpl();
        requiredOptions.add("xml");
        requiredOptions.add("xsd");
        this.description = "Validate given xml";
        this.commandIdentifier = "v";
    }

}
