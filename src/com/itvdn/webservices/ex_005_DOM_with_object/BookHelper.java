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
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 03.12.2017.
 */
public class BookHelper {

    private Document document;

    public BookHelper() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);

        DocumentBuilder db = dbf.newDocumentBuilder();

         document = db.parse("src/com/itvdn/webservices/ex_005_DOM_with_object/books.xml");
    }

    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();

        Element root = document.getDocumentElement();

        NodeList list = root.getElementsByTagName("book");

        for (int i = 0; i < list.getLength(); i++) {
            Book book = new Book();
            Node node = list.item(i);
            String title = root.getElementsByTagName("title").item(i).getFirstChild().getTextContent();
            String author = root.getElementsByTagName("author").item(i).getFirstChild().getTextContent();
            String id = node.getAttributes().item(0).getNodeValue();
            long isdn = Long.parseLong(node.getAttributes().item(1).getNodeValue());

            book.setTitle(title);
            book.setAuthor(author);
            book.setId(id);
            book.setIsdn(isdn);
            books.add(book);
        }

        return books;
    }

    public void addBook(Book newBook) throws FileNotFoundException, TransformerException {
        Element root = document.getDocumentElement();

        Element book = document.createElement("book");
        Element title = document.createElement("title");
        Element author = document.createElement("author");

        book.setAttribute("id", newBook.getId());
        book.setAttribute("isbn", String.valueOf(newBook.getIsdn()) );
        title.setTextContent(newBook.getTitle());
        author.setTextContent(newBook.getAuthor());

        book.appendChild(title);
        book.appendChild(author);

        root.appendChild(book);

        DOMSource source = new DOMSource(document);
        String outputURL = "src/com/itvdn/webservices/ex_005_DOM_with_object/books.xml";

        StreamResult result = new StreamResult(new FileOutputStream(outputURL));

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(source, result);
    }

}
