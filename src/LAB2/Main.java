package LAB2;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        Reader reader = new FileReader("src/LAB2/candies.xml");
        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);
        List<Candy> candies = new ArrayList<>();

        String name = null;
        int sweetness = 0;
        boolean isChocolate = false;

        while (xmlStreamReader.hasNext()) {

            switch (xmlStreamReader.next()) {

                case XMLStreamReader.START_ELEMENT :
                    String elem = xmlStreamReader.getName().toString();
                    switch (elem) {
                        case "name" -> name = xmlStreamReader.getElementText();
                        case "sweetness" -> sweetness = Integer.parseInt(xmlStreamReader.getElementText());
                        case "isChocolate" -> {
                            isChocolate = Boolean.parseBoolean(xmlStreamReader.getElementText());
                            candies.add(new Candy(name, sweetness, isChocolate));
                        }
                    }
                    break;

                case XMLStreamReader.END_ELEMENT :
                    break;

            }
        }

        for (Candy candy : candies) {
            System.out.println(candy);
        }
    }
}
