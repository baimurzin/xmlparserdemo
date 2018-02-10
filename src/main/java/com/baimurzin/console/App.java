package com.baimurzin.console;

import com.baimurzin.command.Command;
import com.baimurzin.command.CommandFactory;
import com.baimurzin.command.CommandRegistry;
import com.baimurzin.command.impl.CommandRegistryImpl;
import com.baimurzin.output.Response;
import com.baimurzin.service.impl.XMLElementCounterServiceImpl;
import com.baimurzin.service.impl.XMLValidationServiceImpl;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App  {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private CommandLineBuilder commandLine;
    private CommandRegistry commandRegistry = CommandRegistryImpl.getInstance();
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
        List<Command> commandList = CommandFactory.getInstance().getCommands(commandLine.getCmd());
        commandList.forEach(command -> {
            Response response = command.execute();
            LOGGER.info("Result from -{} command: {}",command.getCommandIdentifier(), response.getData());
        });
    }

    public class AppBuilder {

        private AppBuilder() {

        }

        public AppBuilder addOptions(Set<Option> options) {
            App.this.options.addAll(options);
            return this;
        }

        public AppBuilder addCommand(Command command) {
            App.this.commandRegistry.register(command);
            return this;
        }

        public App build() {
            Collection<Option> options = commandRegistry
                    .getRegisteredCommands()
                    .stream()
                    .flatMap(command -> command.getOptions().stream())
                    .collect(Collectors.toList());
            App.this.options.addAll(options);
            return App.this;
        }

    }
}
