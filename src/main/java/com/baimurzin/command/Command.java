package com.baimurzin.command;

import org.apache.commons.cli.Option;

import java.util.Set;

/**
 * Common interface for all commands
 */
public interface Command {
    Set<Option> getOptions();

    Object execute();

    void addParameter(String paramName, String value);
}
