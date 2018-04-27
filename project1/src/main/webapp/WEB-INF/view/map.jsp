        <%@ page import="org.project.controller.BuildingController" %>
        <%@ page import="org.project.bean.BuildingBean" %>
        <%@ page import="java.util.ArrayList" %>
        <%@ page import="com.google.gson.Gson" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            height: 100%;
        }

        .slider {
            -webkit-appearance: none;
            width: 500px;
            height: 15px;
            border-radius: 5px;
            background: #d3d3d3;
            outline: none;
            opacity: 0.7;
            -webkit-transition: .2s;
            transition: opacity .2s;
        }

        .slider::-webkit-slider-thumb {
            -webkit-appearance: none;
            appearance: none;
            width: 25px;
            height: 25px;
            border-radius: 50%;
            background: #4CAF50;
            cursor: pointer;
        }

        .slider::-moz-range-thumb {
            width: 25px;
            height: 25px;
            border-radius: 50%;
            background: #4CAF50;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div id="filters">
    <form action="BuildingController" method="get">
        <input type="hidden" name="choice" value="filter">
        <input type="text" name="minPrice" placeholder="minPrice">
        <input type="text" name="maxPrice" placeholder="maxPrice">
        <input type="text" name="minArea" placeholder="minArea">
        <input type="text" name="maxArea" placeholder="maxArea">
        <select name="type">
            <option value="">Tipo</option>
            <option value="Bilocale">Bilocale</option>
            <option value="Trilocale">Trilocale</option>
            <option value="Quadrilocale">Quadrilocale</option>
            <option value="Plurilocale">Plurilocale</option>
            <option value="Loft">Loft</option>
        </select>
        <select name="E_class">
            <option value="">Classe Energetica</option>
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
            <option value="E">E</option>
            <option value="F">F</option>
            <option value="G">G</option>
        </select>
        <input type="text" name="city" placeholder="city">
        <%--	<input type="text" name="minLatitude" placeholder="minLatitude">
            <input type="text" name="maxLatitude" placeholder="maxLatitude">
            <input type="text" name="minLongitude" placeholder="minLongitude">
            <input type="text" name="maxLongitude" placeholder="maxLongitude">--%>
        <input type="submit" value="cerca"/>
    </form>
</div>

<div class="slidecontainer">
    <form action="BuildingController" method="get">
        <input type="hidden" name="choice" value="Range">
        <input type="range" min="0" max="10" value="5" class="slider" id="myRange" name="myRange">
        <p>Distance (km): <span id="demo"></span></p>
        <script>
            var slider = document.getElementById("myRange");
            var output = document.getElementById("demo");
            output.innerHTML = slider.value;

            slider.oninput = function() {
                output.innerHTML = this.value;
            }
        </script>
        <input type="submit" />
    </form>
</div>

<div style="display: none;" id="places">
    ${requestScope['places']}
</div>



<div id="map"></div>

<br>

<script>

    function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
            center: new google.maps.LatLng(45.474687, 9.187337),
            zoom: 14
        });

        //filtered places:
        var filteredPlaces = JSON.parse(document.getElementById('places').innerHTML);

        console.log(filteredPlaces);
        //all places:
       <%--var list1 = '<%=json%>';--%>
       // var places = JSON.parse(list1);

        for (var i = 0; i < filteredPlaces.length; i++) {
            (function () {
                var id = filteredPlaces[i].id;
                var name = filteredPlaces[i].name;
                var address = filteredPlaces[i].address;
                var type = filteredPlaces[i].type;
                var lat = filteredPlaces[i].latitude;
                var lng = filteredPlaces[i].longitude;
                var point = new google.maps.LatLng(lat, lng);

                /*
                        Gianmarco:

                        laying out the pop up window with basic specs on map, for each building.
                        The construction is pretty simple: append children as you would do in a
                        xml document construction. You oughta append every graphical tag you want,
                        in order to get a graphically satisfying result.
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

                var infoWindow = new google.maps.InfoWindow;

                marker.addListener('click', function () {
                    //show info here
                    infoWindow.setContent(infowincontent);
                    infoWindow.open(map, marker);
                });

            }())
        }
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

</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAeZarnT-wYAMc6IZpwls-P6Cf90H_SVRk&callback=initMap">
</script>

</body>
</html>
