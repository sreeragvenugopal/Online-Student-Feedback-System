<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Student Feedback</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="../css/index.css">
<body class="w3-content" style="max-width: 2000px">

	<!-- First Grid: Logo & About -->
	<div class="w3-row">
	<h1><center><%=request.getAttribute("infoMessage")==null?"":request.getAttribute("infoMessage")%></center></h1>
		<div class="w3-half w3-black w3-container w3-center"
			style="height: 700px">
			<div class="w3-padding-64">
				<h1>Co-ordinator Home</h1>
			</div>
			<div class="w3-padding-64">
				<a href="Addnewstudent.jsp"
					class="w3-button w3-black w3-block w3-hover-blue-grey w3-padding-16">Add Students
					</a> <a href=""
					class="w3-button w3-black w3-block w3-hover-blue-grey w3-padding-16">Generate
					Report</a> <a href="changecoordinatorpassword.jsp"
					class="w3-button w3-black w3-block w3-hover-teal w3-padding-16">Change
					Password</a>
			</div>
		</div>

		<image src="..\images\asas.jpg" width="650px" height="700px" />

	</div>


</body>
</html>