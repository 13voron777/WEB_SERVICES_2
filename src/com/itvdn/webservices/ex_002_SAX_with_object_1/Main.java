package com.itvdn.webservices.ex_002_SAX_with_object_1;

import com.itvdn.webservices.ex_001_SAX.MyHandler;
import com.itvdn.webservices.ex_002_SAX_with_object_1.entity.Ingridient;
import com.itvdn.webservices.ex_002_SAX_with_object_1.entity.Sandwich;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Asus on 03.12.2017.
 */
public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SandwichHandler sh = new SandwichHandler();

        File file = new File("src/com/itvdn/webservices/ex_002_SAX_with_object_1/sendwich.xml");
        parser.parse(file, sh);

        Sandwich sandwich = sh.getSandwich();

        System.out.println("Sandwich infos: ");
        System.out.println(sandwich.getTitle());

        List<Ingridient> ingridients = sandwich.getIngridients();

        for (Ingridient ingridient : ingridients) {
            System.out.println(ingridient.getTitle());
        }
    }

}
