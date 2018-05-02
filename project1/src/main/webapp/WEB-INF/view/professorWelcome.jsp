<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        td {
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
    <title>HOME PAGE - Docente</title>
</head>
<body>
   <h1 style="color: SlateBlue; text-align: center; font-size:300%"> UniMarina </h1>
  
    
    <ul style="float: right; top: 100px;">
    <li>Matricola: ${requestScope['professor'].badgeNumber}</li>
   	<li>Nome: ${requestScope['professor'].name}</li>
   	<li>Cognome: ${requestScope['professor'].surname}</li>
   	<li>Email Istituzionale: ${requestScope['professor'].istitutionalEmail}</li>
  
	</ul>
     <table id="menu">
     <tr><th>
     <form method="get" action="LogoutController">
    <button type="submit">Logout</button>
</form>
</th></tr>


</table>
   <table id="examTable" border="1" align="center">
    <tr>
    	<th>ExamCode</th>
        <th>Name</th>
   		<th>Credits</th>
   		<th></th>
   		<th></th>
    </tr>
</table>
 
    <div id="courses">
    <script type="text/javascript">
    // Get the table to be filled.
 let table = document.getElementById( "examTable" );

    let jsonExams = '<%= request.getAttribute( "examsList" ) %>';
    console.log( "JSON_EXAMS: " + jsonExams );
    let exams = JSON.parse( jsonExams );
    let index = 1;
    for (let i in exams) {
        exam = exams[i];
        let row  = table.insertRow( index );
       
        let idRow=row.insertCell(0);
        let nameRow      = row.insertCell( 1 );
        let creditsRow   = row.insertCell( 2 );
        let teachingMaterialButtonRow=row.insertCell(3);
       	let testButtonRow=row.insertCell(4); 
       
        let credits = exam['credits'];
        idRow.innerHTML= exam["idExam"]
        nameRow.innerHTML      = exam['name'];
        creditsRow.innerHTML   = credits;

        //button 1
        teachingMaterialButtonRow.innerHTML= "<input type='button' value='Carica Materiale' class='buttons'  />";
        
        //button 2
        testButtonRow.innerHTML="<input type='button' value='Carica Test' class='buttons' />";
    }

</script>
    </div>



</body>
</html>
