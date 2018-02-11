package com.baimurzin.command.impl;

import com.baimurzin.command.Command;
import com.baimurzin.output.Response;
import com.baimurzin.service.impl.XMLElementCounterServiceImpl;
import org.apache.commons.cli.Option;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class CounterCommand extends AbstractCommand {

    public CounterCommand() {
        requiredOptions.add("xml");
        this.service = new XMLElementCounterServiceImpl();
        this.commandIdentifier = "c";
        this.description = "Count element in given xml";
        this.options.add(new Option(this.getCommandIdentifier(), true, this.getCommandDescription()));
    }
}
