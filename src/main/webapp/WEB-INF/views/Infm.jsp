<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC - HelloWorld Index Page</title>
      
      <link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
      <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
      <!-- Javascript -->
      <script>
         $(function() {
        		 var loc = [];
        		     	  
        		     	  $.ajax({
        		     		  method: "GET",
        		     		  url: "http://localhost:8080/perinfo3/location",
        		     		  async: false,
        		     		  success: function(data) {
        		     			 loc = data;
        		     		  }
        		     	  }); 

            $( "#pin" ).autocomplete({
               source:loc,
          
            	select: function (event, ui) {
            	    	            $("#pin").val(ui.item.label);
            	    	            $("#location").val(ui.item.value);
            	    	            return false; 
            	}
            });
         });
      </script>
</head>
<body>


     

                  
 
	<center>
		<h2>Personal Information</h2>
  <form action="addStudent" method="post">
		  First name  :&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" name="fname" value=""><br>
  <br>
  Last name  :&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" name="lname" value=""><br>
  <br><br>
  Address  :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <textarea name="addr" rows="3" cols="20"></textarea><br>
 
  <br>
   Phone Number  :&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" name="phno" value=""><br>
  <br><br>
  Pin code  :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" id="pin" name="pin" value="">
  Location  :
  <input id=location type="text" name="location" >
  <br>
  
  <br><br>
  <span id="error"></span>
 
		<button type="submit" value="Add Student">Submit</button>
	</center>
	</form>
</body>
</html>
  

  
     <!--   <h1>Add Personal Information</h1>  
       <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>Firstame : </td>   
          <td><form:input path="fname"  /></td>  
         </tr>    
         <tr>    
          <td>Lastname :</td>    
          <td><form:input path="lname" /></td>  
         </tr>   
         <tr>    
          <td>Phonenumber :</td>    
          <td><form:input path="phno" /></td>  
         </tr>   
         <tr>    
          <td>Postalcode :</td>    
          <td><form:input path="pin" /></td>  
         </tr> 
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    -->