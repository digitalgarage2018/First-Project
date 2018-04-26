<%--
  Created by IntelliJ IDEA.
  User: maestro
  Date: 26/04/18
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h1 style="color: SlateBlue; text-align: center; font-size:300%"> UniMarina </h1>
<p> Benvenuto ${requestScope['user'].username}. </p>
<ul>
    <li>Matricola: </li>
    <li>Nome: </li>
    <li>Cognome: </li>
    <li>Email: </li>
    <li>Data di Nascita: </li>
    <li>Piano di Studi: </li>
</ul>
</body>
</html>
