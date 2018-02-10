package com.baimurzin.service.impl;

import com.baimurzin.exceptions.InvalidInputException;
import com.baimurzin.service.XmlService;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class XMLElementCounterServiceImpl implements XmlService<Integer> {

    /**
     * Count the number of certain elements in xml File
     *
     * @param xmlFile target xml file
     * @param elementName tag element name to count in xml file
     * @return the number of elements
     */
    private int countElements(File xmlFile, String elementName) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new InvalidInputException("Not valid config", e);
        }

        Document document = null;
        try {
            document = documentBuilder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            throw new InvalidInputException("File invalid", e);
        }
        return document.getElementsByTagName(elementName).getLength();
    }

    @Override
    public Integer apply(Map<String, String> params) {
        String xmlParam = params.get("xml");
        if (xmlParam == null || xmlParam.isEmpty()) {
            throw new IllegalArgumentException("Xml parameter not valid");
        }
        File xmlFile = new File(xmlParam);
        if (!xmlFile.exists()) {
            throw new IllegalArgumentException("Xml file not found");
        }
        String elementName = params.get("c");
        if (elementName != null) {
            return countElements(xmlFile, elementName);
        } else {
            throw new IllegalArgumentException("No required param specified");
        }
    }
}
