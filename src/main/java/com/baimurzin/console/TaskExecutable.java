package com.baimurzin.console;

import org.apache.commons.cli.CommandLine;

public interface TaskExecutable {
    void execute(CommandLine cmd);
}
