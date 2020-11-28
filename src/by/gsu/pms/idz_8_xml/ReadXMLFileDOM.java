package by.gsu.pms.idz_8_xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ReadXMLFileDOM {

    public void readXML(String uri) {

        try {

            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder =
                    dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(uri);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("note");
            Note note = new Note();
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    note.setFrom(getTagValue("from", eElement));
                    note.setTo(getTagValue("to", eElement));
                    note.setHeading(getTagValue("heading", eElement));
                    note.setBody(getTagValue("body", eElement));

                }
            }
            note.reveal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList =
                eElement.getElementsByTagName(sTag).item(0).getChildNodes();

        Node nValue = nlList.item(0);

        return nValue.getNodeValue();
    }

}