<%-- 
    Document   : index
    Created on : Jul 26, 2017, 11:34:33 PM
    Author     : Elie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
String errorMessage = "";
if(request.getAttribute("errorMessage")!=null)
{
    errorMessage = (String) request.getAttribute("errorMessage");
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Structure projet web</title>
<script>
    
    function checkInputs()
    {
        
        var userName = document.getElementById("userName").value;
        var password = document.getElementById("password").value;
        var errorDiv = document.getElementById("errorDiv");
        
        if(!checkIfInputNull(userName,"userName"))
        {
            return false;
        }
        if(!checkIfInputNull(password,"password"))
        {
            return false
        }
        if(!checkSpecialCarac(userName))
        {
            return false;
        }
        if(!checkSpecialCarac(password))
        {
            return false;
        }
        
        return true;
    }
    
    function checkIfInputNull(inputVal,inputName)//to check if an input is null
    {
        if(inputVal==null || inputVal =="")
        {
            errorDiv.innerHTML = "<h3>the "+inputName+" cannot be empty or null</h3>";
            return false;
        }
        return true;
    }
    
    function checkSpecialCarac(inputtxt)  //to check if an input contains not allowed characters
    {  
       var letterNumber = /^[0-9a-zA-Z_.]+$/;  
       if(inputtxt.match(letterNumber))   
        {  
         return true;  
        }  
      else  
        {   
         errorDiv.innerHTML = "<h3>Illegal characters used</h3>";   
         return false;   
        }  
     } 
    
</script>
</head>
<body>
	<h1>Please Login</h1>
<form action="/ProjetCnamC2/LoginServlet" method="post">
    <div>
        
        <div id="errorDiv" style="color: red"><h3><%=errorMessage%></h3></div>
      
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="userName" id="userName" size="30" maxlength="25"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" id="password" size="30"  maxlength="25"></td>
            </tr>
        </table>
	 <table>
            <tr>
                <td><input type="submit" value="Login" style="align-items: center" onclick="return checkInputs()" /></td>
            </tr>
        </table>
    </div>
    
    
</form>
</body>
</html>
