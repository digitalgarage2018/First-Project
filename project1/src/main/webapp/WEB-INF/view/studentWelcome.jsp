<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>HOME PAGE - Studente</title>
</head>
<body>
<h1 style="color: SlateBlue; text-align: center; font-size:300%"> UniMarina </h1>
<ul style="position: absolute;top: 100px; right: 100px;">
    <li>Matricola: ${requestScope['student'].badgeNumber}</li>
   	<li>Nome: ${requestScope['student'].name}</li>
   	<li>Cognome: ${requestScope['student'].surname}</li>
   	<li>Email Istituzionale: ${requestScope['student'].istitutionalEmail}</li>
    <li>Email Personale: ${requestScope['student'].personalEmail}</li>
    <li>Data di Nascita: ${requestScope['student'].dateOfBirth}</li>
</ul>
<table style="position: absolute;top: 100px; left: 20px;">
	<tr><td>Menu</td></tr>
    <tr><td><button>Modifica Piano di Studi</button></td></tr>
    <tr><td><form action="UniversityBookletController" method="post">
        <input type="submit" value="Visualizza Libretto" />
        <input style="visibility:hidden" name="studyPlanID" value="${requestScope['student'].idPlainOfStudy}">
    </form></td></tr>
 <tr><td>
 <form method="get" action="LogoutController">
    <button type="submit">Logout</button>
</form>
</td></tr>
</table>
<p style="color: SlateBlue;position: absolute; bottom:100px; right: 50px; font-size:260%"> Benvenuto ${requestScope['student'].name}. </p>
</body>
</html>
