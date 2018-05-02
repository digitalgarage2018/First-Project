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
    <input id="submitButton" type="submit">
</form>

</body>
<script>
	document.getElementById("submitButton").disabled = true;
    let totalCredits = 0;
    const CREDITS_THRESHOLD = 60;
    function addEventHandlerCheckboxer( index, credits )
    {
    	var pianoCompleto=false;
        function changeBoxStatus( index, disable )
        {
            let checkBoxes = document.getElementsByClassName( "checkBoxClass" );
            for (let i = 0; i < checkBoxes.length; i++) {
                if (i != index) {
                    let cb = checkBoxes[i];
                    if (!cb['checked']) {
                        if (disable) {
                            cb['disabled'] = true;
                        } else {
                            cb['disabled'] = false;
                        }
                    }
                }
            }
        }

        return function() {
        	
            if (this.checked) {
                totalCredits += credits;
                console.log( "PREMUTO: " + index + ", CREDITS: " + credits + ", TOTAL_CREDITS: " + totalCredits );
                
                if (totalCredits == CREDITS_THRESHOLD) {
                    // Disables all the enabled checkboxes.
                    changeBoxStatus( index - 1, true );
                    document.getElementById("submitButton").disabled = false;
                }
            } else {
                if (totalCredits == CREDITS_THRESHOLD) {
                    // Re-enables all the disabled checkboxes.
                    changeBoxStatus( index - 1, false );
                    document.getElementById("submitButton").disabled = true;
                }

                totalCredits -= credits;
                this.setAttribute( "checked", "false" );
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
        checkBox.classList.add( "checkBoxClass" );
        checkBox.name = "exam";
        checkBox.value = exam['idExam'];
        checkBox.addEventListener( 'click', addEventHandlerCheckboxer( index++, credits ) );
        checkBoxRow.appendChild( checkBox );
    }
  </script>
</html>
