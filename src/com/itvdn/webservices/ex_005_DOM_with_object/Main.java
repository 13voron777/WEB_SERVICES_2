package com.itvdn.webservices.ex_005_DOM_with_object;

import com.itvdn.webservices.ex_005_DOM_with_object.entity.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Asus on 03.12.2017.
 */
public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        BookHelper bh = new BookHelper();

        List<Book> books = bh.getAll();

        for (Book book : books)  {
            System.out.println(book.getId() +  " " + book.getIsdn()
                    + " " + book.getAuthor() + " " + book.getTitle());
        }

        Book book = new Book();
        book.setIsdn(10000);
        book.setId("04");
        book.setAuthor("abcd");
        book.setTitle("This is text...");

        bh.addBook(book);

        System.out.println("------------");

        books = bh.getAll();

        for (Book b : books)  {
            System.out.println(b.getId() +  " " + b.getIsdn()
                    + " " + b.getAuthor() + " " + b.getTitle());
        }

    }

}
