package com.baimurzin.service.impl;

import com.baimurzin.exceptions.InvalidSchemaException;
import com.baimurzin.service.ValidationService;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class XMLValidationServiceImpl implements ValidationService {

    private static final Logger LOGGER = Logger.getLogger(XMLValidationServiceImpl.class.getName());

    private SchemaFactory schemaFactory;

    public XMLValidationServiceImpl() {
        schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    }

    public boolean isValid(String xmlFilePath, String schemaFilePath) {
        File xmlFile = new File(xmlFilePath);
        File schemaFile = new File(schemaFilePath);
        return isValid(xmlFile, schemaFile);
    }

    public boolean isValid(File xmlFile, File schemaFile) {
        Schema schema = null;
        try {
            schema = schemaFactory.newSchema(new StreamSource(schemaFile));
        } catch (SAXException e) {
            throw new InvalidSchemaException("Invalid file input", e);
        }
        Validator validator = schema.newValidator();
        try {
            validator.validate(new StreamSource(xmlFile));
            return true;
        } catch (SAXException | IOException e) {
            throw new InvalidSchemaException("Invalid file input", e);
        }
    }

}
