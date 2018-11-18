
<%@page import="com.feedback.model.TeacherModel"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.beans.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FeedBack</title>
<link rel="stylesheet" href="../css/normalize.css">
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../css/main2.css">
<script language="javascript">
	function fun() {
		var name = document.getElementById("name");
		var branch = document.getElementById("branch");
		var teacher = document.getElementById("teachers");

	}
</script>
</head>
<body>
	<jsp:include page="/Login/header.jsp" />
	<%
		List<TeacherModel> TeacherList = (ArrayList<TeacherModel>) request.getAttribute("teacherList");
	%>


	<form action="removeteacher" method="post">
		<table border="1" cellpadding="9" style="border-collapse: collapse">
			<tbody>
				<tr>
					<th></th>
					<th>ID</th>
					<th>Name</th>
					<th>Subject</th>

				</tr>

				<%
					for (TeacherModel t : TeacherList) {
				%>
				<tr>

					<td><input type="checkbox" name="teachers"
						value="<%=t.getId()%>" /></td>
					<td><%=t.getId()%></td>
					<td><%=t.getName()%></td>
					<td><%=t.getSubject()%></td>

				</tr>

				<%
					}
				%>


			</tbody>
		</table>

		<button type="submit">Remove</button>

	</form>


</body>
</html>