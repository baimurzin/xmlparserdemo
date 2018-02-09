package com.baimurzin;

import com.baimurzin.console.CommandLineBuilder;
import com.baimurzin.service.ElementCounterService;
import com.baimurzin.service.impl.XMLElementCounterServiceImpl;
import org.apache.commons.cli.CommandLine;

public class ApplicationEntryPoint {

    //todo add DI
    private static ElementCounterService elementCounterService = new XMLElementCounterServiceImpl();

    public static void main(String[] args) {
        CommandLine cmd = new CommandLineBuilder()
                .addOption("xml", "xml", true, "Xml file path")
                .addOption("ch", "schema", true, "Schema file path")
                .addOption("v", "validation", false, "Option to validate")
                .addOption("c", "count", true, "Option to count an element")
                .addOption("s", "time", false, "Option to show execution time")
                .build(args);

        //todo

    }
}
