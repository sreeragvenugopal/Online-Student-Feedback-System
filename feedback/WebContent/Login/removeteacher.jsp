  <%@page import="java.beans.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FeedBack</title>
        <link rel="stylesheet" href="../css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="../css/main2.css">
        <script language="javascript" >
function fun()
{
	var name=document.removeteacher.tname.value;
	var dname=document.removeteacher.dname.value;
	if(name=="" || dname=="")
	{
		alert("First Details must be filled");
		return false;
	}
}
</script>
    </head>
    <body>

      <form action="index.html" method="post">
      
        <h1>Remove Teacher</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Remove Teacher</legend>
          <label for="name">Name:</label>
          <input type="text" id="name" name="user_name">
        </fieldset>
        
        
        <fieldset>
        <label for="job">Branch</label>
        <select id="branch" name="dname">
          <optgroup label="">
           <option value="cs">Computer science</option>
            <option value="mths">Maths</option>
            <option value="eng">English</option>
            <option value="comm">Commerce</option>
            <option value="vm">visual Media</option>
    
        </select>
        <fieldset>
        <label for="job">Teachers</label>
        <select id="job" name="tname">
          <optgroup label="">
            <option value=""></option>
            <option value=""></option>
            <option value=""></option>
            <option value=""></option>
            <option value=""></option>
    
        </select>
        
         
        
        </fieldset>

         <button type="submit">Remove</button>
        
      </form>
   
      
    </body>
</html>