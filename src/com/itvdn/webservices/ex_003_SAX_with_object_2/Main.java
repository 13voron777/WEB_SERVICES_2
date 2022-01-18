package com.itvdn.webservices.ex_003_SAX_with_object_2;

import com.itvdn.webservices.ex_001_SAX.MyHandler;
import com.itvdn.webservices.ex_003_SAX_with_object_2.entity.Country;
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

        CountryHandler ch = new CountryHandler();

        File file = new File("src/com/itvdn/webservices/ex_003_SAX_with_object_2/country.xml");
        parser.parse(file, ch);

        List<Country> countries = ch.getCountries();

        System.out.println("All countries: ");

        for (Country country : countries) {
            System.out.println(country.getCode() + " " + country.getName() + " "
                    +  country.getCapital() + " " + country.getDescription());
        }

    }

}
