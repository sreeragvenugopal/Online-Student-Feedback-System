<%@page import="com.feedback.model.TeacherModel"%>
<%@page import="com.feedback.model.QuestionModel"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DatabaseMetaData"%>
<%@ page import="com.feedback.database.DatabaseConnection"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student FeedBack</title>
<link rel="stylesheet" href="../css/normalize.css">
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../css/main2.css">
</head>
<body>
	<jsp:include page="/Login/header.jsp" />
	<%
		List<QuestionModel> questionModelList = (ArrayList<QuestionModel>) request.getAttribute("questionlist");
		List<TeacherModel> teacherModelList = (ArrayList<TeacherModel>) request.getAttribute("teacherlist");
	%>
	<form action="studentfeedback" method="post">

		<h1>FeedBack</h1>

		<fieldset>
			<legend>
				<span class="number">1</span>Department
			</legend>
			<select id="branch" name="dept">
				<optgroup label="">
				<option value="cs">-select-</option>
					<option value="cs">Computer science</option>
					<option value="mths">Maths</option>
					<option value="eng">English</option>
					<option value="comm">Commerce</option>
					<option value="vm">visual Media</option>
			</select>
		</fieldset>

		<fieldset>

			<legend>
				<span class="number">2</span>Teacher
			</legend>
			<select id="teach" name="teacher">
				<%
					for (TeacherModel t : teacherModelList) {
				%>
				<option value="<%=t.getId()%>"><%=t.getName()%></option>
				<%
					}
				%>



			</select>

		</fieldset>
		<fieldset>
			<legend>
				<span class="number">3</span>Year
			</legend>
			<select id="yr" name="year">
				<optgroup label="">
				<option value="">-select-</option>
					<option value="">First Year</option>
					<option value="">Second Year</option>
					<option value="">Third Year</option>
					<option value="">Forth Year</option>
					<option value="">Fifth Year</option>
			</select>
		</fieldset>
		<fieldset>
			<legend>
				<span class="number">4</span>Semester
			</legend>
			<select id="sem" name="semester">
				<optgroup label="">
				<option value="">-select-</option>
					<option value="">1</option>
					<option value="">2</option>
					<option value="">3</option>
					<option value="">4</option>
					<option value="">5</option>
					<option value="">6</option>
					<option value="">7</option>
					<option value="">8</option>
					<option value="">9</option>
					<option value="">10</option>
			</select>
		</fieldset>
		<fieldset>
			<legend>
				<span class="number">5</span>Subjects
			</legend>
			<select id="sub" name="subject">
				<optgroup label="">
				<option value="">-select-</option>
					<option value="">Networking</option>
					<option value="">Cryptography</option>
					<option value="">Introduction To Media</option>
					<option value="">C#</option>
					<option value="">OOAD</option>
			</select>
		</fieldset>

		<h4>Select the perceived performance of the teachers</h4>


		<label> <%
 	for (QuestionModel q : questionModelList) {
 %>
			<fieldset>
				<option value="<%=q.getId()%>"><%=q.getQuestionText()%></option>
				<input type="radio" id="development" value="5" name="<%=q.getId()%>"><label
					class="light" for="development">Outstanding</label><br> <input
					type="radio" id="development" value="4" name="<%=q.getId()%>"><label
					class="light" for="development">Excellent</label><br> <input
					type="radio" id="design" value="3" name="<%=q.getId()%>"><label
					class="light" for="design">Very Good</label><br> <input
					type="radio" id="business" value="2" name="<%=q.getId()%>"><label
					class="light" for="business">Good</label><br> <input
					type="radio" id="business" value="1" name="<%=q.getId()%>"><label
					class="light" for="business">Fair</label>
			</fieldset> <%
 	}
 %>
		</label>




		<button type="submit">Submit</button>
	</form>

</body>
</html>