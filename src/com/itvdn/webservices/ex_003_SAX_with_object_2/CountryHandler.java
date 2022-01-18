package com.itvdn.webservices.ex_003_SAX_with_object_2;

import com.itvdn.webservices.ex_002_SAX_with_object_1.entity.Ingridient;
import com.itvdn.webservices.ex_003_SAX_with_object_2.entity.Country;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class CountryHandler extends DefaultHandler {

    private String currentQName;
    private List<Country> countries;
    private Country currentCountry;
    private String currentAttribute;

    public CountryHandler() {
        countries = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start element: " + qName);
        currentQName = qName;

        if (attributes.getLength() > 0) {
            currentAttribute = attributes.getValue(0);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        System.out.println("Characters: " + value);
        switch (currentQName) {
            case "country" :
                currentCountry = new Country();
                currentCountry.setCode(currentAttribute);
                break;
            case "name" :
                currentCountry.setName(value);
                break;
            case "capital" :
                currentCountry.setCapital(value);
                break;
            case "description" :
                currentCountry.setDescription(value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
        currentQName = "";

        if (qName.equals("country")) {
            countries.add(currentCountry);
        }
    }

    public List<Country> getCountries() {
        return countries;
    }

}
