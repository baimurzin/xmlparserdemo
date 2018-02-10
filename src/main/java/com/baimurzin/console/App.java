package com.baimurzin.console;

import com.baimurzin.command.Command;
import com.baimurzin.command.CommandFactory;
import com.baimurzin.service.impl.XMLElementCounterServiceImpl;
import com.baimurzin.service.impl.XMLValidationServiceImpl;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App  {

    private CommandLineBuilder commandLine;

    private Set<Option> options = new HashSet<>();

    private App() {

    }

    public static AppBuilder newBuilder() {
        return new App().new AppBuilder();
    }

    public void run(String[] args) {
        this.commandLine = new CommandLineBuilder()
                .addOptions(options)
                .build(args);
        List<Command> commandList = CommandFactory.getInstance().getCommands(commandLine);
        commandList.forEach(command -> {
            Object o = command.execute();
            //todo add output
            System.out.println(o);
        });
    }

    public class AppBuilder {

        private AppBuilder() {

        }

        public AppBuilder addOptions(Set<Option> options) {
            App.this.options.addAll(options);
            return this;
        }

        public App build() {
            return App.this;
        }

    }
}
