package org.project.dao;

import java.io.File;
import java.io.StringWriter;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import static org.project.util.DBController.*;

import org.project.bean.BuildingBean;
import org.project.bean.HouseBean;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BuildingDao {

    private static final String SELECT = "SELECT * FROM building WHERE 1=1";
    private static final String SELECT_BUILDING = "SELECT * FROM building";
    private static final String SELECT_BY_RANGE =
            "SELECT * FROM building WHERE (POW ( ( 69.1 * ( longitude - 9.187337 ) * cos( 45.474687 / 57.3 ) ) , 2 ) " +
                    "+ POW( ( 69.1 * ( latitude - 45.474687 ) ) , 2 ) ) < ?";
    private static final String XML_PATH = "/Users/Gianmarco/Desktop/DigitalGarage/First-Project/markers.xml";
    private static final double[] center = {45.464271, 9.191926};



    public ArrayList<BuildingBean> getPlacesByRange(int range) {
        ArrayList<BuildingBean> result = new ArrayList<>();

        /*

        Gianmarco: trying to retrieve data given a range on map;

         */
        try {
            if(connectDB(SELECT_BY_RANGE)) {
                stmt.setString(1, range + ""); //setting up the query String...
                rs = stmt.executeQuery();

                while(rs.next()) {
                    BuildingBean place = new BuildingBean();
                    place.setId(Integer.parseInt(rs.getObject(1).toString()));
                    place.setName(rs.getObject(2).toString());
                    place.setAddress(rs.getObject(3).toString());
                    place.setCity(rs.getObject(4).toString());
                    place.setLatitude(Double.parseDouble(rs.getObject(5).toString()));
                    place.setLongitude(Double.parseDouble(rs.getObject(6).toString()));
                    place.setType(rs.getObject(7).toString());
                    place.setPrice(Integer.parseInt(rs.getObject(8).toString()));
                    place.setArea(Integer.parseInt(rs.getObject(9).toString()));
                    place.seteClass(rs.getObject(10).toString());

                    result.add(place);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }

        return result;
    }


    public List<BuildingBean> find(Map<String, String> parameters) {
        List<BuildingBean> houses = new ArrayList<>();

        String minPrice, maxPrice, minSize, maxSize, minLatitude, maxLatitude, minLongitude, maxLongitude;

        System.out.println(parameters);

        minPrice = parameters.get("minPrice");
        maxPrice = parameters.get("maxPrice");
        minSize = parameters.get("minSize");
        maxSize = parameters.get("maxSize");
        /*
        minLatitude = parameters.get("minLatitude");
        maxLatitude = parameters.get("maxLatitude");
        minLongitude = parameters.get("minLongitude");
        maxLongitude = parameters.get("maxLongitude");
        */
        StringBuilder query = new StringBuilder();

        query.append(SELECT);

        if(minPrice != null && maxPrice != null && !minPrice.equals("") && !maxPrice.equals("")) {
            query.append(" and");
            query.append(" Price>" + minPrice);
            query.append(" and");
            query.append(" Price<" + maxPrice);
        }

        if(minSize != null && maxSize != null && !minSize.equals("") && !maxSize.equals("")) {
            query.append(" and");
            query.append(" Size>" + minSize);
            query.append(" and");
            query.append(" Size<" + maxSize);
        }
        /*
        if(minLatitude != null && maxLatitude != null && !minLatitude.equals("") && !maxLatitude.equals("")) {
            query.append(" and");
            query.append(" Latitude>" + minLatitude);
            query.append(" and");
            query.append(" Latitude<" + maxLatitude);
        }

        if(minLongitude != null && maxLongitude != null && !minLongitude.equals("") && !maxLongitude.equals("")) {
            query.append(" and");
            query.append(" Longitude>" + minLongitude);
            query.append(" and");
            query.append(" Longitude<" + maxLongitude);
        }
        */
        System.out.println(query.toString());

        try {

            if(connectDB(query.toString())) {
                rs = stmt.executeQuery();

                while(rs.next()){
                    BuildingBean place = new BuildingBean();
                    place.setId(Integer.parseInt(rs.getObject(1).toString()));
                    place.setName(rs.getObject(2).toString());
                    place.setAddress(rs.getObject(3).toString());
                    place.setCity(rs.getObject(4).toString());
                    place.setLatitude(Double.parseDouble(rs.getObject(5).toString()));
                    place.setLongitude(Double.parseDouble(rs.getObject(6).toString()));
                    place.setType(rs.getObject(7).toString());
                    place.setPrice(Integer.parseInt(rs.getObject(8).toString()));
                    place.setArea(Integer.parseInt(rs.getObject(9).toString()));
                    place.seteClass(rs.getObject(10).toString());

                    houses.add(place);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }

        return houses;
    }



    //method grabMarkerData()
    public static ArrayList<BuildingBean> getUpdatedPlacesFromDB() {

        ArrayList<BuildingBean> listPlaces = new ArrayList<BuildingBean>();
        try {

            if(connectDB(SELECT_BUILDING)) {
                rs = stmt.executeQuery();

                while(rs.next()) {
                    BuildingBean place = new BuildingBean();
                    place.setId(Integer.parseInt(rs.getObject(1).toString()));
                    place.setName(rs.getObject(2).toString());
                    place.setAddress(rs.getObject(3).toString());
                    place.setCity(rs.getObject(4).toString());
                    place.setLatitude(Double.parseDouble(rs.getObject(5).toString()));
                    place.setLongitude(Double.parseDouble(rs.getObject(6).toString()));
                    place.setType(rs.getObject(7).toString());
                    place.setPrice(Integer.parseInt(rs.getObject(8).toString()));
                    place.setArea(Integer.parseInt(rs.getObject(9).toString()));
                    place.seteClass(rs.getObject(10).toString());

                    listPlaces.add(place);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnectDB();
        }

        return listPlaces;
    }


    public static Document generateXML() throws TransformerException,
            ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element results = doc.createElement("buildings");
        doc.appendChild(results);

        try {
            if(connectDB(SELECT_BUILDING)) {
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
