        <%@ page import="org.project.controller.MarkerController" %>
        <%@ page import="org.project.bean.MarkerBean" %>
        <%@ page import="java.util.ArrayList" %>
        <%@ page import="com.google.gson.Gson" %>
        <%--
   Created by IntelliJ IDEA.
   User: Gianmarco
   Date: 24/04/18
   Time: 18:20
   To change this template use File | Settings | File Templates.
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Interactive Map</title>
    <style>
        #map {
            height: 600px;
            width: 600px;
        }
    </style>
</head>
<body>

<h3>Search!</h3>

<%
    /*    MarkerController placesToView = new MarkerController();
    Document places = null;
    try {
        places = placesToView.getXMLPlaces();
    } catch (Exception e) {
            System.out.println("Exception occurred" + e.toString());
        }
*/
    //MAYBE I SHOULD JUST GRAB DATA FROM DB WITH DAO AND CONTROLLER, CREATE A MARKERBEAN AND INJECT IT HERE...

    MarkerController placesToView = new MarkerController();
    ArrayList<MarkerBean> markerList = placesToView.grabPlaces();

    for (MarkerBean el : markerList)
        System.out.println(el.toString() + "\n");

    String json = new Gson().toJson(markerList);

%>




<br>


</br>

<div id="map"></div>
<script>

    function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
            center: new google.maps.LatLng(45.474687, 9.187337),
            zoom: 12
        });

        var infoWindow = new google.maps.InfoWindow;

        //trying to retrieve the xml doc to put into downloadUrl. CHECK
        //at this time, I'm just loading the markers.xml file in which I put the markers...

        //I must specify a correct URL (localhost) -- ask
/*        downloadUrl('/Users/Gianmarco/Desktop/DigitalGarage/First-Project/markers.xml', function(data) {
            var xml = data.responseXML;
            var markers = xml.documentElement.getElementsByTagName('marker');
            Array.prototype.forEach.call(markers, function(markerElem) {
                var id = markerElem.getAttribute('id');
                var name = markerElem.getAttribute('name');
                var address = markerElem.getAttribute('address');
                var type = markerElem.getAttribute('type');
                var point = new google.maps.LatLng(
                    parseFloat(markerElem.getAttribute('latitude')),
                    parseFloat(markerElem.getAttribute('longitude')));

                /*
                Gianmarco:

                laying out the pop up window with basic specs on map, for each building
                The construction is pretty simple: append children as you would do in a
                xml document construction. You oughta append every graphical tag you want,
                in order to get a graphically satisfying result
                *//*
                var infowincontent = document.createElement('div');
                var strong = document.createElement('strong');
                strong.textContent = name
                infowincontent.appendChild(strong);
                infowincontent.appendChild((document.createElement('br')));
                var text = document.createElement('text');
                text.textContent = address
                infowincontent.appendChild(text);
                //you can even customize an icon -- I'm staying with the standard here...

                var marker = new google.maps.Marker({
                    map: map,
                    position: point
                    //later I shall add a custom label, maybe iterate over an array just to number each occurrence
                });
                /*
                Gianmarco:
                now I'm setting up a listener, so that I can dinamically pass the mouse onto a
                marker (or click on it), and visualize the infowincontent pop-up...
                *//*
                marker.addListener('click', function() {
                    infoWindow.setContent(infowincontent);
                    infoWindow.open(map, marker);
                });
             });
        });

*/
        var list1 = '<%=json%>';
        var places = JSON.parse(list1);
        var placeName = places.map(place => place.name)
        console.log(list1);
        console.log(places);
        console.log(places[0].id);
        console.log(places[1].address);
        console.log(places[1].latitude);
        console.log(places[1].longitude);

        for (var i = 0; i < places.length; i++) {
            var id = places[i].id;
            var name = places[i].name;
            var address = places[i].address;
            var type = places[i].type;
            var lat = places[i].latitude;
            var lng = places[i].longitude;
            var point = new google.maps.LatLng(lat, lng);

            var infowincontent = document.createElement('div');

            /*
                    Gianmarco:

                    laying out the pop up window with basic specs on map, for each building
                    The construction is pretty simple: append children as you would do in a
                    xml document construction. You oughta append every graphical tag you want,
                    in order to get a graphically satisfying result
                    */
            var infowincontent = document.createElement('div');
            var strong = document.createElement('strong');
            strong.textContent = name;
            infowincontent.appendChild(strong);
            infowincontent.appendChild((document.createElement('br')));
            var text = document.createElement('text');
            text.textContent = address;
            infowincontent.appendChild(text);
            //you can even customize an icon -- I'm staying with the standard here...

            var marker = new google.maps.Marker({
                map: map,
                position: point
                //later I shall add a custom label, maybe iterate over an array just to number each occurrence
            });

            marker.addListener('click', function () {
                infoWindow.setContent(infowincontent);
                infoWindow.open(map, marker);
            });

        }
        /*
        temporary labels for markers:
        maybe later I should import markers from mysql table (ready
        to be load in mysql_server)

        var labels = '123456';

        var markers = locations.map(function (location, i) {
            return new google.maps.Marker({
                position: location,
                label: labels[i % labels.length],
                map: map
            });
        });
        */
    }

    /*
    Gianmarco: implement the downloadURL function -- signature: standard, from googlemapsAPI
     */
 /*   function downloadUrl(url, callback) {
        var request = window.ActiveXObject ?
            new ActiveXObject('Microsoft.XMLHTTP') :
            new XMLHttpRequest;

        request.onreadystatechange = function() {
            if (request.readyState == 4) {      //don't know what that 4 means...
                request.onreadystatechange = doNothing;
                callback(request, request.status);
            }
        };

        request.open('GET', url, true);
        request.send(null);
    } */

    function doNothing() {}
/*
    var locations = [
        {lat: 45.491684, lng: 9.204736},
        {lat: 45.477931, lng: 9.141652},
        {lat: 45.479081, lng: 9.182454},
        {lat: 45.477285, lng: 9.192178},
        {lat: 45.483139, lng: 9.197228},
        {lat: 45.477429, lng: 9.195515}
    ]
*/
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAeZarnT-wYAMc6IZpwls-P6Cf90H_SVRk&callback=initMap">
</script>
</body>
</html>
