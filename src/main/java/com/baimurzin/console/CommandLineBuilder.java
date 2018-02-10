package com.baimurzin.console;

import org.apache.commons.cli.*;

import java.util.Set;

//todo refactor
public class CommandLineBuilder {


    private CommandLine cmd;
    private CommandLineParser commandLineParser;
    private Options options;
    private HelpFormatter formatter;

    public CommandLineBuilder() {
        this.options = new Options();
        this.commandLineParser = new DefaultParser();
        this.formatter = new HelpFormatter();
    }

    public CommandLineBuilder addOption(Option op) {
        this.options.addOption(op);
        return this;
    }

    public CommandLineBuilder addOptions(Set<Option> options) {
        options.forEach(this::addOption);
        return this;
    }

    public CommandLineBuilder addOption(String shortName, boolean hasArg, String desc) {
        Option option = new Option(shortName, hasArg, desc);
        return this.addOption(option);
    }

    public CommandLineBuilder addOption(String shortName, String fullName, boolean hasArg, String desc) {
        Option option = new Option(shortName, fullName, hasArg, desc);
        return this.addOption(option);
    }

    //todo
    public CommandLineBuilder build(String[] args) {
        try {
            this.cmd = commandLineParser.parse(this.options, args);
        } catch (ParseException e) {
            formatter.printHelp("Application name", this.options);
            System.exit(0);
        }

        return this;
    }

    public CommandLine getCmd() {
        return cmd;
    }

    public void setCmd(CommandLine cmd) {
        this.cmd = cmd;
    }

    public CommandLineParser getCommandLineParser() {
        return commandLineParser;
    }

    public void setCommandLineParser(CommandLineParser commandLineParser) {
        this.commandLineParser = commandLineParser;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public HelpFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(HelpFormatter formatter) {
        this.formatter = formatter;
    }
}
