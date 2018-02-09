package com.baimurzin.service;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public interface ValidationService {

    //todo add methods which implements different file source
    boolean isValid(String xmlFilePath, String schemaFilePath);
    boolean isValid(File xmlFile, File schemaFile) throws SAXException, IOException;
}
