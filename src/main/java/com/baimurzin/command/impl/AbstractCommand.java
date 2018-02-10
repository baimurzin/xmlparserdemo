package com.baimurzin.command.impl;

import com.baimurzin.service.XmlService;
import org.apache.commons.cli.Option;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AbstractCommand {
    protected Set<Option> options = new HashSet<>();
    protected Set<String> requiredOptions = new HashSet<>();
    protected HashMap<String, String> parameters = new HashMap<>();
    protected XmlService service;

    public AbstractCommand() {
        Option xmlOption = new Option("xml", true, "Xml file path");
        xmlOption.setRequired(true);
        this.options.add(xmlOption);
    }

}
