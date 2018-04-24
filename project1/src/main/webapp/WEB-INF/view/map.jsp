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
    <meta charset="utf-8">
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
<div id="map"></div>
<script>
    function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 12,
            center: {lat: 45.474687, lng: 9.187337}
        });
        //adding markers from mysql...later

        /*
        temporary labels for markers:
        maybe later I should import markers from mysql table (ready
        to be load in mysql_server)
        */
        var labels = '123456';

        var markers = locations.map(function (location, i) {
            return new google.maps.Marker({
                position: location,
                label: labels[i % labels.length],
                map: map
            });
        });
    }

    var locations = [
        {lat: 45.491684, lng: 9.204736},
        {lat: 45.477931, lng: 9.141652},
        {lat: 45.479081, lng: 9.182454},
        {lat: 45.477285, lng: 9.192178},
        {lat: 45.483139, lng: 9.197228},
        {lat: 45.477429, lng: 9.195515}
    ]

</script>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAeZarnT-wYAMc6IZpwls-P6Cf90H_SVRk&callback=initMap">
</script>
</body>
</html>
