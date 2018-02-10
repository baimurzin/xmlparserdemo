package com.baimurzin;

import com.baimurzin.command.CommandFactory;
import com.baimurzin.command.CommandRegistry;
import com.baimurzin.command.impl.CommandRegistryImpl;
import com.baimurzin.command.impl.CounterCommand;
import com.baimurzin.command.impl.ValidationCommand;
import com.baimurzin.console.App;
import com.baimurzin.console.CommandLineBuilder;
import org.apache.commons.cli.CommandLine;

public class ApplicationEntryPoint {

    //todo add DI to all services, make services as singletons, divide on several pom modules
    //todo to use one for console app, another one for web and last one as a common core module
    //todo make output module more extendable
    //todo make some logic and design improvements to achieve better flexibility

    public static void main(String[] args) {
        //to define new command just put into registry before application start
        App.newBuilder()
                .addCommand(new CounterCommand())
                .addCommand(new ValidationCommand())
                .build()
                .run(args);
    }
}
