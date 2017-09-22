/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.MangeObject.UserController;
import StockManagement.ObjectModel.ObjectInterface.IUser;
import StockManagement.ObjectModel.ValueObject.User;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mfaour
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;

    private boolean loggedIn;

    //validate login
    public String validateUsernamePassword() {
        User loggedInUser = new User();
        loggedInUser.setUsrUsername(getUsername());;
        loggedInUser.setUsrPassword(getPassword());
        IUser controller = new UserController();
        loggedInUser = controller.login(loggedInUser);
        if (null != loggedInUser && loggedInUser.getUsrCode() > 0) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("CurrentUser", loggedInUser);
            loggedIn = true;
            return "company";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the loggedIn
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @param loggedIn the loggedIn to set
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
