package com.itvdn.webservices.ex_004_DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Asus on 03.12.2017.
 */
public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true); //дл€ того, чтобы игнорировать пробелы

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse("src/com/itvdn/webservices/ex_004_DOM/books.xml");

        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());


        NodeList list = root.getElementsByTagName("book");

        for (int i = 0; i < list.getLength(); i++) {
            Node book = list.item(i);;
            System.out.println("Book name: " + root.getElementsByTagName("title").item(i).getFirstChild().getTextContent());
            System.out.println("Author name: " + root.getElementsByTagName("author").item(i).getFirstChild().getTextContent());
            System.out.println("ID: " + book.getAttributes().item(0).getNodeValue());
            System.out.println("ISBN: " + book.getAttributes().item(1).getNodeValue());
            System.out.println();
        }


//        NodeList nl = root.getChildNodes();
//        for (int i = 0; i < nl.getLength(); i++) {
//            // ѕо номеру получаем узел
//            Node node = nl.item(i);
//            // ѕровер€ем определенный тип, если узел не €вл€етс€ элементом, то пропускаем
//            if (node.getNodeType() != Node.ELEMENT_NODE) {
//                continue;
//            }
//
//            System.out.println("Book:");
//            NodeList childNodes = node.getChildNodes();
//
//            for (int j = 0; j < childNodes.getLength(); j++) {
//                Node childNode = childNodes.item(j);
//                if (childNode.getNodeType() != Node.ELEMENT_NODE) {
//                    continue;
//                }
//
//                String nodeName = childNode.getNodeName();
//                if (nodeName.equals("author")) {
//                    System.out.println("Author: " + childNode.getTextContent());
//                } else if (nodeName.equals("title")) {
//                    System.out.println("Title: " + childNode.getTextContent());
//                }
//            }
//
//            System.out.println("----------------------");
//        }


    }

}
