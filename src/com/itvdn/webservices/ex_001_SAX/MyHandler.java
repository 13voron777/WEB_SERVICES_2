package com.itvdn.webservices.ex_001_SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Asus on 27.11.2017.
 */
public class MyHandler extends DefaultHandler {

    @Override
    public void startDocument() {
        System.out.println("Start Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);

        if (attributes.getLength() > 0) {
            System.out.println("First attribute: " + attributes.getQName(0) + " " + attributes.getValue(0));
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
    }

    @Override
    public void endDocument() {
        System.out.println("End Document");
    }

}
