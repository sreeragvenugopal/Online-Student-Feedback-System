<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet" href="../css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="../css/main2.css">
</head>
<body>
<form name="changepass" action="changepass" method="post">
 <fieldset>
  <label for="password">Current Password:</label>
          <input type="password" id="password" name="currentpass" required>
          
           <label for="password">New Password:</label>
          <input type="password" id="password" name="newpass" required>
          
           <label for="password">Confirm Password:</label>
          <input type="password" id="password" name="cnfrmpass" required>
          
           <button type="submit">Change Password</button>
          
 </fieldset>
</form>
</body>
</html>