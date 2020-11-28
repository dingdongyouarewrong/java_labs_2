package by.gsu.pms.idz_8_xml;

public class Runner {
    public static void main(String[] argv) {
        String uri = "https://www.w3schools.com/xml/note.xml";

        System.out.println("\nRead StAX");
        ReadXMLFileStAX xmlReaderStAX = new ReadXMLFileStAX();
        xmlReaderStAX.readXML(uri);
        System.out.println("\nRead DOM");
        ReadXMLFileDOM xmlReaderDOM = new ReadXMLFileDOM();
        xmlReaderDOM.readXML(uri);
        System.out.println("\nRead SAX");
        ReadXMLFileSAX xmlReaderSAX = new ReadXMLFileSAX();
        xmlReaderSAX.readXML(uri);
    }
}