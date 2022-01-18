package com.itvdn.webservices.ex_002_SAX_with_object_1;

import com.itvdn.webservices.ex_002_SAX_with_object_1.entity.Ingridient;
import com.itvdn.webservices.ex_002_SAX_with_object_1.entity.Sandwich;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Asus on 03.12.2017.
 */
public class SandwichHandler extends DefaultHandler {

    private Sandwich sandwich;
    private String currentQName;
    private int countIngridients;

    public SandwichHandler() {
        sandwich = new Sandwich();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
        currentQName = qName;
        countIngridients = (attributes.getLength() > 0) ? Integer.parseInt(attributes.getValue(0)) : 1;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (!(value.startsWith("\n"))) {
            System.out.print("Characters: ");
        }

        System.out.println(value);

        switch (currentQName) {
            case "title" :
                    sandwich.setTitle(value);
                break;
            case "ingridient" :
                Ingridient ingridient = new Ingridient(value);
                for (int i = 0; i < countIngridients; i++) {
                    sandwich.addIngridient(ingridient);
                }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        currentQName = "";
    }


    public Sandwich getSandwich() {
        return sandwich;
    }

}
