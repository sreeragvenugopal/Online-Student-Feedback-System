  
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
        <script type="text/javascript">
<<<<<<< HEAD
        
        var username=document.getElementById("uname");
        var name=document.getElementById("name");
        var pass=document.getElementById("password");
        var repass=document.getElementById("repassword");
        var branch=document.getElementById("branch");
        var subject=document.getElementById("subject");
        var batch=document.getElementById("batch");
        
        if(username=="" || name=="" ||pass=="" ||repass=="" ||branch=="" ||subject=="" ||batch=="" )
        	{
        	 var x = document.getElementById("myDIV");
        	 x.style.display = "none";
        	}
        </script>
=======
        function validate(){
        var uname=document.getElementById("uname");
        var name=document.getElementById("name");
        var pass=document.getElementById("password");
        var repass=document.getElementById("repassword");
        var branch=document.getElementById("branch");
        var subject=document.getElementById("subject");
        var type=document.getElementById("type");
        var batch=document.getElementById("batch");
        
        if(username.equals("") || name.equals("") || password.equals("") ||  repassword.equals("")||  branch.equals("") || subject.equals("")  )
		{
				
        	var x = document.getElementById("myDIV");
        	x.style.display = "block";
        	return;
			
		} 
        
        
        
        }
        
        
        </script>
       <style>
#myDIV {
    width: 100%;
    padding: 50px 0;
    text-align: center;
    margin-top: 20px;
    display: none;
    }
</style>
>>>>>>> branch 'master' of https://github.com/sreeragvenugopal/new.git
    </head>
    <style>
#myDIV {
    width: 100%;
    padding: 50px 0;
    text-align: center;
    margin-top: 20px;
    display:block;
	}
</style>
    <body>
    <h1><div id="myDIV" >Filed's Can't be Empty</div></h1>
    <% 
      List<ClassModel> classModelList = (ArrayList<ClassModel>)request.getAttribute("classList");
    
 	  %>
 
      <form name="addnewteacher" action="addnewteacher" method="post">
      
        <h1>Add Teacher</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Add New Teacher</legend>
           <label for="name">User-Name:</label>
<<<<<<< HEAD
          <input type="text" id="uname" name="username">
=======
          <input type="text" id="uname" name="username" required>
>>>>>>> branch 'master' of https://github.com/sreeragvenugopal/new.git
          
          <label for="name">Name:</label>
          <input type="text" id="name" name="name" required>
          
          <label for="password">Password:</label>
          <input type="password" id="password" name="pass" required>
          
          <label for="password">Re-Enter Password:</label>
          <input type="password" id="repassword" name="repass" required>
          
        </fieldset>
        
        
        <fieldset>
        <label for="job">Branch</label>
<<<<<<< HEAD
        <select id="branch" name="branch">
=======
        <select  id="branch" name="branch" required>
>>>>>>> branch 'master' of https://github.com/sreeragvenugopal/new.git
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
<<<<<<< HEAD
        <select id="subject" name="subject">
=======
        <select id="subject" name="subject" required>
>>>>>>> branch 'master' of https://github.com/sreeragvenugopal/new.git
          <optgroup label="">
            <option value="Networking">Networking</option>
            <option value="Cryptography">Cryptography</option>
            <option value="Introduction To Media">Introduction To Media</option>
            <option value="C#">C#</option>
            <option value="OOAD">OOAD</option>
        </select>
        </fieldset>
        
        <fieldset>
        <label for="type">Type</label>
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
        
        <button type="submit" onclick="validate()">Create Teacher</button>
         <button type="submit">Reset</button>
        
      </form>
<<<<<<< HEAD
      <h1><div id="myDIV">Fileds Must Be Filled</div></h1>
=======
      
>>>>>>> branch 'master' of https://github.com/sreeragvenugopal/new.git
      
    </body>
</html>