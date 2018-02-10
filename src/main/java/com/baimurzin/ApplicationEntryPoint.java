package com.baimurzin;

import com.baimurzin.command.CommandFactory;
import com.baimurzin.command.impl.CounterCommand;
import com.baimurzin.command.impl.ValidationCommand;
import com.baimurzin.console.App;
import com.baimurzin.console.CommandLineBuilder;
import org.apache.commons.cli.CommandLine;

public class ApplicationEntryPoint {

    private static CommandFactory commandFactory = CommandFactory.getInstance();

    //todo add DI to all services

    public static void main(String[] args) {
        App.newBuilder()
                .addOptions(commandFactory.registerCommands(new CounterCommand()))
                .addOptions(commandFactory.registerCommands(new ValidationCommand()))
                .build()
                .run(args);
    }
}
