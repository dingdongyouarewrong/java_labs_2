package by.gsu.pms.idz_8_xml;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFileSAX {

    public static void main(String[] argv) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            Note note = new Note();
            DefaultHandler handler = new DefaultHandler() {

                boolean toExists = false;
                boolean fromExists = false;
                boolean headingExists = false;
                boolean bodyExists = false;

                @Override
                public void startElement(String uri, String localName,String
                        qName, Attributes attributes) {

                    if (qName.equalsIgnoreCase("to")) {
                        toExists = true;
                    }

                    if (qName.equalsIgnoreCase("from")) {
                        fromExists = true;
                    }

                    if (qName.equalsIgnoreCase("heading")) {
                        headingExists = true;
                    }

                    if (qName.equalsIgnoreCase("body")) {
                        bodyExists = true;
                    }

                }

                @Override
                public void characters(char[] ch, int start, int length) {

                    if (toExists) {
                        String to = new String(ch, start, length);
                        note.setTo(to);
                        toExists = false;
                    }

                    if (fromExists) {
                        String from = new
                                String(ch, start, length);
                        note.setFrom(from);
                        fromExists = false;
                    }

                    if (headingExists) {
                        String heading = new
                                String(ch, start, length);
                        note.setHeading(heading);
                        headingExists = false;
                    }

                    if (bodyExists) {
                        String body = new
                                String(ch, start, length);

                        note.setBody(body);
                        bodyExists = false;
                    }

                }



            };

            saxParser.parse("https://www.w3schools.com/xml/note.xml", handler);

            note.reveal();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

