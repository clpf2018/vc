/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnam.gestionstock.servlet.core;

import cnam.gestionstock.common.InputControlException;
import cnam.gestionstock.bean.core.LoginBean;
import cnam.gestionstock.bean.core.UserBean;
import cnam.gestionstock.bean.core.MenuBean;
import cnam.gestionstock.dao.core.LoginDAOImpl;
import cnam.gestionstock.dao.core.LoginDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;


/**
 *
 * @author Elie
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private LoginDAO loginDAO;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
                LoginBean login = new LoginBean();
                String path = "/jsp/core/mainFrame.jsp";
                ServletContext sc = this.getServletContext();
	        String userName = request.getParameter("userName");
                String password = request.getParameter("password");
                RequestDispatcher rd = null;
                
                
                /***controlling username and password inputs on the server side ***/
                
                if(userName==null || "".equals(userName) || "null".equals(userName))
                {
                   rd = sc.getRequestDispatcher("/index.jsp");
                   throw new InputControlException("the username can't be a null value",request,response,rd); 
                }
                    
                if(password==null || "".equals(password) || "null".equals(password))
                {
                    rd = sc.getRequestDispatcher("/index.jsp");
                    throw new InputControlException("the password can't be a null value",request,response,rd);
                }
                    
                if(userName.length()>25 || password.length()>25)
                {
                  rd = sc.getRequestDispatcher("/index.jsp");  
                  throw new InputControlException("wrong username/password",request,response,rd);    
                }
                
                UserBean user = new UserBean();
                user.setUserName(userName);
                user.setPassword(password);
                login.setUser(user);
                
                loginDAO = new LoginDAOImpl();
                int userId=-1;
                
                //if userId  is different than -1 then the user exists in the DB
                userId = loginDAO.validateLogin(login);
                
	       if(userId == -1)
               {
                    path =  "/index.jsp";
                    request.setAttribute("errorMessage", "username/password are incorrect");
               }
               else
               {
                   // if the user entered exists we should get its menu
                   MenuBean[] menus = loginDAO.getUserMenus(userId);
                   HttpSession session = request.getSession();
                   session.setAttribute("menus", menus);
               }
                rd= sc.getRequestDispatcher(path);
	        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
