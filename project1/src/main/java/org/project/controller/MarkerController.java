package org.project.controller;

import org.project.bean.MarkerBean;
import org.project.dao.MarkerDao;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServlet;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;

public class MarkerController extends HttpServlet {

    public MarkerController() {
        super();
    }

    public ArrayList<MarkerBean> grabPlaces() {
            return MarkerDao.getUpdatedPlacesFromDB();
    }


    public Document getXMLPlaces() throws TransformerException, ParserConfigurationException {
        return MarkerDao.generateXML();
    }


}
