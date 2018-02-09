package com.baimurzin.console;

import org.apache.commons.cli.*;

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

    public CommandLineBuilder addOption(String shortName, boolean hasArg, String desc) {
        Option option = new Option(shortName, hasArg, desc);
        return this.addOption(option);
    }

    public CommandLineBuilder addOption(String shortName, String fullName, boolean hasArg, String desc) {
        Option option = new Option(shortName, fullName, hasArg, desc);
        return this.addOption(option);
    }

    //todo
    public CommandLine build(String[] args) {
        try {
            this.cmd = commandLineParser.parse(this.options, args);
        } catch (ParseException e) {
            formatter.printHelp("Applicataion name", this.options);
        }

        return this.cmd;
    }
}
