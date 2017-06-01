<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC - HelloWorld Index Page</title>
      </head>
<body>
<center>
		<h2><b>Create New User</b></h2>
 <form action="addUser" method="POST">
		  Username  :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" name="uname" value=""><br>
  <br>
  Password  :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="password" name="pword" value="">
  <br><br>
   Confirm Password  :&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="password" name="cnfmpword" value=""><br>
  <br><br>
 <button type="submit" value="addUser">Submit</button>
	</center>
	</form>
</body>
</html>