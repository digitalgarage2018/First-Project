<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	table, td {
    border: 1px solid black;
    border-collapse: collapse;
	}
	td ,ths{
    padding: 5px;
    text-align: left;    
	}
	#dati{
	float: left;

	}
	#courses{
	margin-left: 30%;;
	
	}
</style>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Benvenuto Docente</title>
</head>
<body>
<h1 style="color: SlateBlue; text-align: center; font-size:300%"> UniMarina </h1>
<p> Benvenuto Prof. ${requestScope['user'].username}. </p>
<div id="dati">
	 <table style="width:15%;padding:1px; border:1px solid">
	<tr>
    <th>Dati Docente</th>
	</tr>
	<tr>
    <td >Matricola:</td>
    <td>${requestScope['professor'].badgeNumber</td>
	</tr>
	<tr>
    <td>Nome:</td>
    <td>${requestScope['professor'].name</td>
	</tr>
	<tr>
    <td>Cognome:</td>
    <td>${requestScope['professor'].surname</td>
	</tr>
	<tr>
    <td>Email:</td>
    <td>${requestScope['professor'].email</td>
    </tr>
</table> 
</div>
<div id="courses">
<ul>
  <li>Exam 1 -per ora in sospeso</li>
  <li>Exam 2</li>
  <li>Exam 3</li>
</ul>  
</div>
<p> <button type="button"  style="float: right;">Logout</button> </p>
</body>
</html>