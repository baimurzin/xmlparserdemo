package com.baimurzin.service.impl;

import com.baimurzin.exceptions.InvalidDataException;
import com.baimurzin.service.XmlService;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class XMLValidationServiceImpl implements XmlService<Boolean> {

    private SchemaFactory schemaFactory;

    public XMLValidationServiceImpl() {
        schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    }

    @Override
    public Boolean apply(Map<String, String> params) {
        String xsd = params.get("xsd");
        String xml = params.get("xml");
        if(xsd != null && xml != null) {
            return isValid(xml, xsd);
        } else {
            throw new IllegalArgumentException("Xsd file not found");
        }
    }

    /**
     * Check whether the file is valid or not
     *
     * @param xmlFilePath path to xml file
     * @param schemaFilePath path to schema
     * @return true if file valid otherwise returns false
     */
    private boolean isValid(String xmlFilePath, String schemaFilePath) {
        File xmlFile = new File(xmlFilePath);
        File schemaFile = new File(schemaFilePath);
        return isValid(xmlFile, schemaFile);
    }

    private boolean isValid(File xmlFile, File schemaFile) {
        Schema schema = null;
        try {
            schema = schemaFactory.newSchema(new StreamSource(schemaFile));
        } catch (SAXException e) {
            throw new InvalidDataException("Invalid file input", e);
        }
        Validator validator = schema.newValidator();
        try {
            validator.validate(new StreamSource(xmlFile));
            return true;
        } catch (SAXException e) {
            return false;
        } catch (IOException e) {
            throw new InvalidDataException("File not specified");
        }
    }

}
