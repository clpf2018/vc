<%-- 
    Document   : index
    Created on : Jul 26, 2017, 11:34:33 PM
    Author     : Elie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Structure projet web</title>

</head>
<body>
	<h1>Structure Projet C2</h1>
<form action="/ProjetCnamC2/ClientServlet" method="post">
    <div>
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="userName" size="20"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" size="20"></td>
            </tr>
        </table>
	 <table>
            <tr>
                <td><input type="submit" value="Login" style="align-items: center"/></td>
            </tr>
        </table>
    </div>
    
    
</form>
</body>
</html>
