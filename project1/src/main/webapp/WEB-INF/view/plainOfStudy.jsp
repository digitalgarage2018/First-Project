<%--
  Created by IntelliJ IDEA.
  User: maestro
  Date: 28/04/18
  Time: 00:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="librettoStyle.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>${requestScope['user'].username} Piano Di Studi</title>
</head>
<body>
<!-- Student name. -->
<p>${requestScope['user'].username}</p>
<!-- List of exams to chose. -->
<table id="examTable", border="1">
    <tr>
        <th>Name</th>
        <th>Professor</th>
        <th>Credits</th>
        <th>Mark</th>
    </tr>
</table>

</body>
<script>
    let table = document.getElementById( "examTable" );

    let exams = JSON.parse(${requestScope['allExams']});
    console.log( "JSON_EXAMS: " + jsonExams );
    let totalCredits = 0.0;
    let totalMarks   = 0.0;
    let index = 1;
    for (let i in exams) {
        exam = exams[i];
        let row  = table.insertRow( index++ );
        let nameRow      = row.insertCell( 0 );
        let professorRow = row.insertCell( 1 );
        let creditsRow   = row.insertCell( 2 );
        let markRow      = row.insertCell( 3 );

        let credits = exam['credits'];
        let mark    = exam['mark'];

        nameRow.innerHTML      = exam['name'];
        professorRow.innerHTML = exam['professor'];
        creditsRow.innerHTML   = credits;
        if (mark > 0) {
            markRow.innerHTML  = mark;
            totalCredits += credits;
            totalMarks   += mark * credits;
        }
    }
</script>
</html>
