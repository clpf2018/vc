<%-- 
    Document   : menuPage
    Created on : Jul 30, 2017, 4:37:28 PM
    Author     : Elie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="cnam.gestionstock.bean.core.MenuBean" %>


<%
    MenuBean [] menus = (MenuBean[])session.getAttribute("menus");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
       <div id="demo1_menu">
    <ul>
        <% 
        String previousMenuType = "PC";
        int menusLength = menus.length;
        for(int i=0;i<menus.length;i++)
         {
             if(menus[i].getMenuType() == "PC")
             {
              if(previousMenuType.equals("C"))    
              {
        %>
            </ul>
             <%}%>
        <li><a href="../../jsp/client/clientModif.jsp" target="pagesFrame"><%=menus[i].getMenuName()%></a></li>
            <%
             }
             else
              if(menus[i].getMenuType() == "P")
             {
           if(previousMenuType.equals("C"))    
              {
              

        %>
            </ul>
             <%}%>
        <li class="isFolder isExpanded" title="Bookmarks">
            <%=menus[i].getMenuName()%>
            <ul>
                <%
                    }
              else
              if(menus[i].getMenuType() == "C")
             {  
                previousMenuType = "C";
                %>
               <li><a href="http://www.google.com" target="pagesFrame"><%=menus[i].getMenuName()%></a></li>
             <%}
             if(i>0 && (i-1) == menusLength)
             {
             %>
            </ul>
            <%}
         }
        %>
    </ul>
</div>
    </body>
</html>
