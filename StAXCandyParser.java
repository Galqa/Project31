package task4;


/*
 Використовуючи StAX-парсер, отримати колекцію Candy з xml-файлу.
*/

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StAXCandyParser {
    public static void main(String[] args) {

        List<Candy> candies = new ArrayList<>(); // список для зберігання об'ктів Candy
        try {
            // фабрика для читання
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(new FileInputStream("C:\\Users\\My comp\\IdeaProjects\\Lesson49\\src\\main\\java\\task4\\candies.xml"));


            Candy candy = null; // змінна для зберігання об'єкта Candy

            // проводимо перебір подій
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent(); // наступна подія
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String tagName = startElement.getName().getLocalPart();
                    if (tagName.equals("candy")) {
                        candy = new Candy();
                        Attribute nameAttr = startElement.getAttributeByName(new QName("name"));
                        Attribute energyAttr = startElement.getAttributeByName(new QName("energy"));

                        candy.setName(nameAttr.getValue());
                        candy.setEnergy(Integer.parseInt(energyAttr.getValue()));
                    }

                    if (tagName.equals("type")) {
                        event = reader.nextEvent();
                        candy.getTypes().add(event.asCharacters().getData());
                    }


                    if (tagName.equals("ingredients")) {
                        Attribute waterAttr = startElement.getAttributeByName(new QName("water"));
                        Attribute sugarAttr = startElement.getAttributeByName(new QName("sugar"));
                        Attribute typeAttr = startElement.getAttributeByName(new QName("type"));

                        candy.setWater(Integer.parseInt(waterAttr.getValue()));
                        candy.setSugar(Integer.parseInt(sugarAttr.getValue()));
                        candy.setIngredientType(typeAttr.getValue());
                    }

                    if (tagName.equals("production")) {
                        event = reader.nextEvent();
                        candy.setProduction(event.asCharacters().getData());
                    }
                }

                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement(); // Отримуємо тег як об'єкт EndElement
                    String tagName = endElement.getName().getLocalPart();

                    if (tagName.equals("candy")) {
                        candies.add(candy);
                    }
                }
            }

            // Виводимо список об'єктів Candy
            for (Candy c : candies) {
                System.out.println(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




