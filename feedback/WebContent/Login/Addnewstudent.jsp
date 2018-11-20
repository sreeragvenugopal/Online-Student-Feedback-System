<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.feedback.model.ClassModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FeedBack</title>
<link rel="stylesheet" href="../css/normalize.css">
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../css/main2.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validate(addnewteacher) {

		var pass = document.getElementById("password").value;
		var repass = document.getElementById("repassword").value;

		if (pass != repass) {
			alert("Your password and confirmation password do not match.");
			addnewteacher.repass.focus();
			return false;
		}

	}
</script>
</head>
<body>
	<jsp:include page="/Login/header.jsp" />
	<%
		List<ClassModel> classModelList = (ArrayList<ClassModel>) request.getAttribute("classList");
	%>
	<form name="addnewstudent" action="addnewstudent" method="post">



		<h1>Add Student</h1>

		<fieldset>
			<legend>
				<span class="number">1</span>Add New Student
			</legend>
			<label for="name">User-Name:</label> <input type="text" id="uname"
				name="username" required> <label for="name">Name:</label> <input
				type="text" id="name" name="name" required> <label
				for="regnum">Register Number:</label> <input type="text"
				id="registernumber" name="registernumber" required> <label
				for="password">Password:</label> <input type="password"
				id="password" name="pass" required> <label for="password">Re-Enter
				Password:</label> <input type="password" id="repassword" name="repass"
				required>


		</fieldset>


		<fieldset>
			<label for="job">Branch</label> <select id="branch" name="branch"
				required>
				<option value="">-select-</option>
				<option value="Computer science">Computer science</option>
				<option value="Maths">Maths</option>
				<option value="English">English</option>
				<option value="Commerce">Commerce</option>
				<option value="Visual Media">Visual Media</option>
			</select>
		</fieldset>

		<fieldset>
			<label for="batch">Batch</label> <select id="batch" name="model">
				<%
					for (ClassModel c : classModelList) {
				%>
				<option value="<%=c.getId()%>"><%=c.getName()%></option>
				<%
					}
				%>

			</select>
		</fieldset>




		<button type="submit" onclick="return validate(this);">Create
			Student</button>
		<button type="reset">Reset</button>

	</form>
	<h1>
		<center><%=request.getAttribute("successMessage") == null ? "" : request.getAttribute("successMessage")%></center>
	</h1>

</body>
</html>