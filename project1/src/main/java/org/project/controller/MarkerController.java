package org.project.controller;

import org.project.dao.MarkerDao;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServlet;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class MarkerController extends HttpServlet {

    public MarkerController() {
        super();
    }

    public Document getXMLPlaces() throws TransformerException, ParserConfigurationException {
        return MarkerDao.generateXML();
    }


}
