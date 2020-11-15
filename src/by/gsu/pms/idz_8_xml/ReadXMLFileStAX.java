package by.gsu.pms.idz_8_xml;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class ReadXMLFileStAX {
    boolean toExists = false;
    boolean fromExists = false;
    boolean headingExists = false;
    boolean bodyExists = false;
    Note note = new Note();
    String passDefault;
    public void readXML(String uri) {
        URL url = null;
        try {
            url = new URL(uri);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            assert url != null;
            try (InputStream input = url.openStream()) {



                XMLInputFactory factory = XMLInputFactory.newInstance();
                XMLEventReader eventReader = factory.createXMLEventReader(uri, input);
                while(eventReader.hasNext()) {
                    XMLEvent event = eventReader.nextEvent();

                    switch (event.getEventType()) {
                        case XMLStreamConstants.START_ELEMENT -> startEvent(event);
                        case XMLStreamConstants.CHARACTERS -> charactersEvent(event);
                        case XMLStreamConstants.END_ELEMENT -> endEvent(event);
                        default -> passDefault();

                    }
                }

            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
        note.reveal();

    }
    public void passDefault() {
        passDefault = "pass";
    }

    public void endEvent(XMLEvent event) {
        EndElement endElement = event.asEndElement();
        if (endElement.getName().getLocalPart().equalsIgnoreCase("student")) {
            System.out.println();
        }
    }

    public void startEvent(XMLEvent event) {
        StartElement startElement = event.asStartElement();
        String qName = startElement.getName().getLocalPart();
        if (qName.equalsIgnoreCase("note")) {
            System.out.println("Start Element : note");
        } else if (qName.equalsIgnoreCase("to")) {
            toExists = true;
        } else if (qName.equalsIgnoreCase("from")) {
            fromExists = true;
        } else if (qName.equalsIgnoreCase("heading")) {
            headingExists = true;
        } else if (qName.equalsIgnoreCase("body")) {
            bodyExists = true;
        }
    }

    public void charactersEvent(XMLEvent event) {
        Characters characters = event.asCharacters();
        if (toExists) {
            note.setTo(characters.getData());
            toExists = false;
        }
        if (fromExists) {
            note.setFrom(characters.getData());
            fromExists = false;
        }
        if (headingExists) {
            note.setHeading(characters.getData());
            headingExists = false;
        }
        if (bodyExists) {
            note.setBody(characters.getData());
            bodyExists = false;
        }
    }



}