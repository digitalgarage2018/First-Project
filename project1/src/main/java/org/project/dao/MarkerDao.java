package org.project.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.Format;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import static org.project.util.DBController.*;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MarkerDao {

    private static final String SELECT_MARKERS = "SELECT * FROM markers";
    private static final String XML_PATH = "/Users/Gianmarco/Desktop/DigitalGarage/First-Project/markers.xml";


    public static Document generateXML() throws TransformerException,
            ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element results = doc.createElement("markers");
        doc.appendChild(results);

        try {
            if(connectDB(SELECT_MARKERS)) {
                rs = stmt.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
                int colCount = rsmd.getColumnCount();

                while(rs.next()) {
                    //create xml element...
                    Element marker = doc.createElement("marker");
                    results.appendChild(marker);
                    //...set its attributes
                    for(int i = 1; i <= colCount; i++) {
                        //System.out.println(rsmd.getColumnName(i) + " : " + rs.getObject(i).toString());
                        Attr attr = doc.createAttribute(rsmd.getColumnName(i));
                        attr.setValue(rs.getObject(i).toString());
                        marker.setAttributeNode(attr);
                    }
                }
            }
        } catch (SQLException sqlExp) {
            System.out.println("SqlExcp: " + sqlExp.toString());
        } finally {
            disconnectDB();
        }

        //change, depending on where do the others wanna keep the xml with places
        //I could keep it as a static variable...future refactoring
        saveXML(doc, XML_PATH);

        return doc;
    }

    public static void saveXML(Document document, String pathname) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult((new File(pathname)));
        Source input = new DOMSource(document);

        transformer.transform(input, output);
    }

    //just in case...for testing
    public static String prettyPrintXML(Document doc) throws TransformerException {

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        //initialize StreamResult with File object to save to file
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);
        String xmlString = result.getWriter().toString();
        //System.out.println(xmlString);

        return xmlString;
    }

}
