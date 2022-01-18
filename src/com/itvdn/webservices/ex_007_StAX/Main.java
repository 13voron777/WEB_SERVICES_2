package com.itvdn.webservices.ex_007_StAX;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * Created by Asus on 03.12.2017.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();

        Reader reader = new FileReader("src/com/itvdn/webservices/ex_007_StAX/books.xml");

        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);

        while (xmlStreamReader.hasNext()) {
            switch (xmlStreamReader.next()) {

                case XMLStreamReader.START_ELEMENT :
                    String elem = xmlStreamReader.getName().toString();

                    switch (elem) {
                        case "book" :
                            for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                String attributeValue = xmlStreamReader.getAttributeValue(i);

                                System.out.println(attributeName + " " + attributeValue);
                            }
                            break;
                        case "title" :
                            System.out.println("Title: " + xmlStreamReader.getElementText());
                            break;
                        case "author" :
                            System.out.println("Author: " + xmlStreamReader.getElementText() + "\n");
                            break;
                    }
                    System.out.println("Start element: " + xmlStreamReader.getName());
                    break;

                case XMLStreamReader.END_ELEMENT :
                    System.out.println("End element: " + xmlStreamReader.getName());
                    break;

            }
        }

    }

}
