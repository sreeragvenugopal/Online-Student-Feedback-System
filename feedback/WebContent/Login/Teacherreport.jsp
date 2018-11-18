
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.beans.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Teacher Report</title>
<link rel="stylesheet" href="../css/normalize.css">
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../css/main2.css">
<script language="javascript">
	
</script>
</head>
<body>
	<jsp:include page="/Login/header.jsp" />
	<%
		Map<String, Long> outputReportMap = (LinkedHashMap<String, Long>) request.getAttribute("outputReportMap");
		Set<String> questionSet = outputReportMap.keySet();
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