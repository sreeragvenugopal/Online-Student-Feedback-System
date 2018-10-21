  <%@page import="java.beans.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Teacher Report</title>
        <link rel="stylesheet" href="../css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="../css/main2.css">
        <script language="javascript" >
function fun1()
{
	var name=document.addnewteacher.user_name.value;
	var dname=document.addnewteacher.branch.value;
	if(name=="" || dname=="")
	{
		alert("First Details must be filled");
		return false;
	}
}
</script>
    </head>
    <body>

        <form name="teacherreport" action="teacherreport1" method="post" onsubmit="return fu1()" >
      
        <h1>Teacher Report Generate</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Report</legend>
          <label for="name">Department:</label>
          <input type="text" id="name" name="dept">
        </fieldset>
        
        
        <fieldset>
        <label for="job">Name of Teacher</label>
        <select id="branch" name="tname">
          <optgroup label="">
           <option value="cs"></option>
            <option value="mths"></option>
            <option value="eng"></option>
            <option value="comm"></option>
            <option value="vm"></option>
    
        </select>
        <fieldset>
        <label for="job">Subject</label>
        <select id="job" name="tname">
          <optgroup label="">
            <option value="">Networking</option>
            <option value="">Cryptography</option>
            <option value="">Introduction To Media</option>
            <option value="">C#</option>
            <option value="">OOAD</option>
        </select>
        
         
        
        </fieldset>

         <button type="submit">Generate</button>
        
      </form>
   
      
    </body>
</html>