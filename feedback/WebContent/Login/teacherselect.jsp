<%@page import="java.util.HashSet"%>
<%@page import="com.feedback.model.TeacherModel"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/normalize.css">
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../css/main2.css">
</head>
<body>
	<jsp:include page="/Login/header.jsp" />
	<%
		List<TeacherModel> teacherModelList = (ArrayList<TeacherModel>) request.getAttribute("teacherlist");
		String selectedid = (String) request.getAttribute("selectedid");
		int id = selectedid != null ? Integer.parseInt(selectedid) : 0;
	%>
	<form action="generateReport" method="post">
		<h1>Select Teacher</h1>
		<fieldset>

			<legend>
				<span class="number">*</span>Teacher
			</legend>
			<select id="teach" name="teacher">
				<%
					for (TeacherModel t : teacherModelList) {
						Boolean isselected = (id == t.getId()) ? true : false;
						String s = isselected ? "selected" : "";
				%>
				<option value="<%=t.getId()%>" <%=s%>><%=t.getName()%></option>
				<%
					}
				%>



			</select>
		</fieldset>
		<button type="submit">Generate</button>
	</form>

	<br>

	<%
		Map<String, Long> outputReportMap = (LinkedHashMap<String, Long>) request.getAttribute("outputReportMap");
		Set<String> questionSet = outputReportMap != null ? outputReportMap.keySet() : new HashSet();
		Map<Long, String> markMap = new HashMap<>();
		markMap.put(5L, "Outstanding(5)");
		markMap.put(4L, "Excellent(4)");
		markMap.put(3L, "Very Good(3)");
		markMap.put(2L, "Good(2)");
		markMap.put(1L, "Fair(1)");
	%>
	<h1>Teacher Report Generate</h1>


	<table border="1" cellpadding="9" style="border-collapse: collapse"
		align="center">
		<tr>
			<th>Question</th>
			<th>Feedback</th>
		</tr>
		<%
			for (String question : questionSet) {
		%>
		<tr>
			<td><%=question%></td>
			<td><%=markMap.get(outputReportMap.get(question))%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>