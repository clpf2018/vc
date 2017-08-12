/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnam.gestionstock.common;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elie
 */
public class InputControlException extends Exception{
    public InputControlException(String message,HttpServletRequest request, HttpServletResponse response,RequestDispatcher rd){
     super(message);
        try {
            request.setAttribute("errorMessage", message);
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(InputControlException.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InputControlException.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    
}
