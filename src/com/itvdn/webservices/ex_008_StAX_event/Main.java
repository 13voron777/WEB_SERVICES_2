package com.itvdn.webservices.ex_008_StAX_event;


import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

/**
 * Created by Asus on 03.12.2017.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();

        Reader reader = new FileReader("src/com/itvdn/webservices/ex_008_StAX_event/books.xml");

        XMLEventReader xmlEvent = factory.createXMLEventReader(reader);

        while (xmlEvent.hasNext()) {
            XMLEvent event = xmlEvent.nextEvent();

            switch (event.getEventType()) {
                case XMLStreamReader.START_ELEMENT :
                    StartElement startElement = event.asStartElement();

                    String elem = startElement.getName().toString();

                    switch (elem) {
                        case "book" :
                            Iterator<Attribute> iterator = startElement.getAttributes();

                            while (iterator.hasNext()) {
                                Attribute attribute = iterator.next();
                                System.out.println(attribute.getName() + " = " + attribute.getValue());
                            }

                            break;
                        case "title" :
                            System.out.println("Title: " + xmlEvent.getElementText());
                            break;
                        case "author" :
                            System.out.println("Author: " + xmlEvent.getElementText() + "\n");
                            break;
                    }
                    break;

            }
        }

    }

}
