package com.itvdn.webservices.ex_009_StAX_create;


import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.util.Iterator;

/**
 * Created by Asus on 03.12.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException, XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("src/com/itvdn/webservices/ex_009_StAX_create/output.xml"));

        writer.writeStartDocument();
        writer.writeStartElement("books");
        writer.writeStartElement("book");
        writer.writeAttribute("id", "03");
        writer.writeAttribute("isdn", "221122");

        writer.writeStartElement("title");
        writer.writeCharacters("Title");
        writer.writeEndElement();

        writer.writeStartElement("author");
        writer.writeCharacters("Andrew");
        writer.writeEndElement();

        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeEndDocument();

        writer.flush();
        writer.close();
    }

}
