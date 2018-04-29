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
<form id="formTable", action="PlainOfStudyController", method="post">
    <table id="examTable", border="1">
        <tr>
            <th>Name</th>
            <th>Professor</th>
            <th>Credits</th>
            <th></th>
        </tr>
    </table>
    <input type="submit">
</form>

</body>
<script>
    let totalCredits = 0;

    function addEventHandlerCheckboxer( index, credits )
    {
        return function() {
            // This will contain a reference to the checkbox.
            if (this.checked) {
                totalCredits += credits;
                console.log( "PREMUTO: " + index + ", CREDITS: " + credits + ", TOTAL_CREDITS: " + totalCredits );
            } else {
                totalCredits -= credits;
                console.log( "NON PREMUTO: " + index + ", CREDITS: " + credits + ", TOTAL_CREDITS: " + totalCredits );
            }
        }
    }

    let table = document.getElementById( "examTable" );

    let jsonExams = '<%= request.getAttribute( "allExams" ) %>';
    console.log( "JSON_EXAMS: " + jsonExams );
    let exams = JSON.parse( jsonExams );
    let index = 1;
    for (let i in exams) {
        exam = exams[i];
        let row  = table.insertRow( index );
        let nameRow      = row.insertCell( 0 );
        let professorRow = row.insertCell( 1 );
        let creditsRow   = row.insertCell( 2 );
        let checkBoxRow  = row.insertCell( 3 );

        let credits = exam['credits'];

        nameRow.innerHTML      = exam['name'];
        professorRow.innerHTML = exam['professor'];
        creditsRow.innerHTML   = credits;
        
        let checkBox = document.createElement( 'input' );
        checkBox.type = "checkbox";
        checkBox.id = "examCheck";
        checkBox.name = "exam";
        checkBox.value = exam['idExam'];
        checkBox.addEventListener( 'click', addEventHandlerCheckboxer( index++, credits ) );
        checkBoxRow.appendChild( checkBox );
    }
</script>
</html>
