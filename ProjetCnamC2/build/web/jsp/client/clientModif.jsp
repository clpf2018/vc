<%-- 
    Document   : clientModif
    Created on : Jul 26, 2017, 11:31:35 PM
    Author     : Elie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="cnam.gestionstock.bean.client.ClientBean" %>
    
    <%
      String userName = (String) request.getAttribute("userName");
      ClientBean client = (ClientBean) request.getAttribute("client");
    %>
    

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Structure projet web</title>
</head>
<body>
	<h1>Recevoir un paramètre (ici userName) d'un JSP à un autre et lire les valeurs des attributs d'un bean </h1>
<form action="" method="post">
    <p>Your username: <b  style="color: lime"><%=userName%></b></p>
    <p>Your Client name is: <b style="color: red"><%=client.getCltName()%></b></p>
    </br>
    </br>
    </br>
    <p>Ce premier commit est juste pour mettre la structure du projet web et standardiser la manière dont on va créer les packages et répertoires ainsi que la convention des noms des classes, packages,....</br>
        Pour chaque module on va creer des packages ayant le nom du module sous les packages principaux où on va créer nos fichiers JAVA:
    <ul>
        <li>cnam.gestionstock.bean</li>
        <li>cnam.gestionstock.dao</li>
        <li>cnam.gestionstock.servlet</li>
    </ul>
    Par exemple pour le module item on aura les packages suivants:
    <ul>
        <li>cnam.gestionstock.bean.item</li>
        <li>cnam.gestionstock.dao.item</li>
        <li>cnam.gestionstock.servlet.item</li>
    </ul>
    N.B: Tous les lettres du nom d'un package doivent être minuscule.
    </p>
	
    De même pour la partie interface, pour chaque module on va créer un répertoire ayant le même nom du module (toutes les lettres étant en minuscule) sous la répertoire 'jsp'.
    
    Les noms des classes et interfaces JAVA doivent toujours commencer par des lettres majuscules et doivent toujours contenir les préfixes suivant par analogie avec leur packages:'Servlet','Bean','DAO','DAOImpl'.
    </br>Les noms des fichiers JSP doivent toujours commencer par des lettres minuscules.
    Le flux des requests va être le suivant:<h2>JSP-->Servlet-->(DAO;DAOImpl)-->BD-->(DAO;DAOImpl)-->Servlet-->JSP</h2>
 
</form>
</body>
</html>