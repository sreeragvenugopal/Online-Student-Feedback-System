
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FeedBack</title>
<link rel="stylesheet" href="../css/normalize.css">
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="../css/main2.css">
</head>
<body>
	<jsp:include page="/Login/header.jsp" />
	<form name="addnewteacher" action="index.html" method="post">

		<h1>Add New Admin</h1>

		<fieldset>
			<legend>
				<span class="number">1</span>New Admin
			</legend>
			<label for="name">Name:</label> <input type="text" id="name"
				name="user_name"> <label for="password">Password:</label> <input
				type="password" id="password" name="user_password"> <label
				for="password">Re-Enter Password:</label> <input type="password"
				id="repassword" name="reuser_password">

			<button type="submit">Sign Up</button>
			<button type="submit">Reset</button>
	</form>

</body>
</html>