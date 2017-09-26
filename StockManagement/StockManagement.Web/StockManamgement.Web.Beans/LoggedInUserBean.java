/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.User;
import java.util.Optional;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Khalil Bsaibes
 */
@ManagedBean(name="LoggedInUser")
@RequestScoped
public class LoggedInUserBean {

    /**
     * Creates a new instance of LoggedInUserBean
     */
    private String fullname;

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        HttpSession session = SessionUtils.getSession();
        Object objUsr = session.getAttribute("CurrentUser");
        if ( null == objUsr)
            return "";
        return ((User)objUsr).getUsrFullname();
    }
    
    public LoggedInUserBean() {
    }
    
}
