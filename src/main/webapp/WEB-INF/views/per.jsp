<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC -HelloWorld</title>
</head>
<body>
	<center>
		<h2>personal information</h2>
		
		 <table>
    <tr>
        <td>First Name</td>
       <td>${fname}</td>
       
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${lname}</td>
    </tr>
    <tr>
        <td>Address</td>
        <td>${addr}</td>
    </tr>
    <tr>
        <td>Phone number</td>
        <td>${phno}</td>
    </tr>
    <tr>
        <td>Pin code</td>
        <td>${pin}</td>
    </tr>
</table> 
	</center>
</body>
</html>