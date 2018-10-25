  
  <%@ page import="java.util.List" %>
 <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.feedback.model.ClassModel" %>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
  
  
  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FeedBack</title>
        <link rel="stylesheet" href="../css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="../css/main2.css">
    </head>
    <body>
    <% 
      List<ClassModel> classModelList = (ArrayList<ClassModel>)request.getAttribute("classList");
    
 	  %>
      <form name="addnewteacher" action="addnewteacher" method="post">
      
        <h1>Add Teacher</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Add New Teacher</legend>
           <label for="name">User-Name:</label>
          <input type="text" id="name" name="username">
          
          <label for="name">Name:</label>
          <input type="text" id="name" name="name">
          
          <label for="password">Password:</label>
          <input type="password" id="password" name="pass">
          
          <label for="password">Re-Enter Password:</label>
          <input type="password" id="repassword" name="repass">
          
        </fieldset>
        
        
        <fieldset>
        <label for="job">Branch</label>
        <select id="job" name="branch">
          <optgroup label="">
            <option value="Computer science">Computer science</option>
            <option value="Maths">Maths</option>
            <option value="English">English</option>
            <option value="Commerce">Commerce</option>
            <option value="Visual Media">Visual Media</option>
        </select>
        </fieldset>
        
        <fieldset>
        <label for="job">Subject</label>
        <select id="job" name="subject">
          <optgroup label="">
            <option value="Networking">Networking</option>
            <option value="Cryptography">Cryptography</option>
            <option value="Introduction To Media">Introduction To Media</option>
            <option value="C#">C#</option>
            <option value="OOAD">OOAD</option>
        </select>
        </fieldset>
        
        <fieldset>
        <label for="job">Type</label>
          <input type="radio" id="" value="Coordinator" name="iscoordinator"><label class="light" for="">Co-ordinator</label>&nbsp&nbsp&nbsp
          <input type="radio" id="" value="Teacher" name="iscoordinator"><label class="light" for="">Teacher</label>
        </fieldset>
        
        <fieldset>
        <label for="batch">Batch</label>
  		<select id="batch" name="model">
        <%for(ClassModel c :classModelList){ %>
            <option value="<%=c.getId()%>"><%=c.getName()%></option>
        <%} %>
        
    	</select>
        </fieldset>
        
        <button type="submit" >Create Teacher</button>
         <button type="submit">Reset</button>
        
      </form>
      <h1><div id="ff" >LLLLLLLLLLLLLL</div></h1>
      
    </body>
</html>