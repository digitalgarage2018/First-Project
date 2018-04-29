<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <link rel="stylesheet" type="text/css" href="librettoStyle.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>${requestScope['user'].username} University Booklet</title>
</head>
<body>
<!-- Student name. -->
<p>${requestScope['user'].username}</p>
<!-- List of exams chose. -->
<table id="examTable", border="1">
    <tr>
        <th>Name</th>
        <th>Professor</th>
        <th>Credits</th>
        <th>Mark</th>
    </tr>
</table>

<!-- JavaScript will fill this with the achieved credits. -->
<p id="credits"/>
<!-- JavaScript will fill this with the average mark. -->
<p id="averageMark"/>
</body>

<script type="text/javascript">
    // Get the table to be filled.
    let table = document.getElementById( "examTable" );

    let jsonExams = '<%= request.getAttribute( "examsPlan" ) %>';
    console.log( "JSON_EXAMS: " + jsonExams );
    let exams = JSON.parse( jsonExams )['exams'];
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

        //console.log( "INDEX: " + i + ", " +
        //			 "EXAM: " + exam['matricolaProfessor'] );
    }

    // TODO controllare la trasformazione da 30-esimi a 110-esimi
    // TODO soprattutto se e' piu' vicino al valore sopra o quello sotto.

    //window.onload = function()
    //{
    // When the document is finished loading, replace everything
    // between the <a ...> </a> tags with the actual value.
    let avgMark = 0;
    if (totalCredits > 0) {
        avgMark = Math.trunc( ((totalMarks / totalCredits) / 30.0) * 110.0 );
    }
    document.getElementById( "averageMark" ).innerHTML = "Average Mark: " + avgMark + "/110";
    document.getElementById( "credits" ).innerHTML = "Credits: " +totalCredits + "/60";
    //}
</script>
</html>
