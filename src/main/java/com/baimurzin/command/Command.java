package com.baimurzin.command;

import com.baimurzin.output.Response;
import org.apache.commons.cli.Option;

import java.util.Set;

/**
 * Common interface for all commands
 */
public interface Command {

    String getCommandIdentifier();
    Set<Option> getOptions();
    Response execute();
    void addParameter(String paramName, String value);
    String getCommandDescription();
    Set<String> getRequiredOptions();
    void parseArguments(Option[] options);
}
