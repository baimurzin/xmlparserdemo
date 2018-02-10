package com.baimurzin.command.impl;

import com.baimurzin.command.Command;
import com.baimurzin.service.impl.XMLElementCounterServiceImpl;
import org.apache.commons.cli.Option;

import java.util.Set;

public class CounterCommand extends AbstractCommand implements Command{

    public CounterCommand() {
        this.options.add(new Option("c", true,"Option to count an element"));
        this.service = new XMLElementCounterServiceImpl();
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
}
