package com.baimurzin.service.impl;

import com.baimurzin.exceptions.InvalidSchemaException;
import com.baimurzin.service.ElementCounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLElementCounterServiceImpl implements ElementCounterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XMLElementCounterServiceImpl.class);


    //We can design this class to handle a file in different way, and store  it as a local variable
    //to make smth operation
    public int countElements(File xmlFile, String elementName) {
        if (xmlFile == null) {
            throw new IllegalArgumentException();
        }
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            //todo refactor change to more semantic name
            throw new InvalidSchemaException("Not valid conifg", e);
        }

        Document document = null;
        try {
            document = documentBuilder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            //add excepiton context
            throw new InvalidSchemaException("File invalid", e);
        }
        return document.getElementsByTagName(elementName).getLength();
    }
}
