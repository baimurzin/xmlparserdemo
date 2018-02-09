package com.baimurzin.console;

import com.baimurzin.service.ElementCounterService;
import com.baimurzin.service.ValidationService;
import com.baimurzin.service.impl.XMLElementCounterServiceImpl;
import com.baimurzin.service.impl.XMLValidationServiceImpl;
import org.apache.commons.cli.CommandLine;

public class App implements TaskExecutable {

    private ElementCounterService counterService = new XMLElementCounterServiceImpl();
    private ValidationService validationService = new XMLValidationServiceImpl();


    public void execute(CommandLine cmd) {

    }
}
