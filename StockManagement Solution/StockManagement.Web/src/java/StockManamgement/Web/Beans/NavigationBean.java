/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mfaour
 */
@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {
 
 
    public String redirectToHome() {
        return "/secured/company.xhtml?faces-redirect=true";
    }

    public String toHome() {
        return "/secured/company.xhtml";
    }
    
    public String redirectToLogin() {
        return "/login.xhtml?faces-redirect=true";
    }

    public String toLogin() {
        return "/login.xhtml";
    }

    public String redirectToLogout() {
        return "/logout.xhtml?faces-redirect=true";
    }

    public String toLogout() {
        return "/logout.xhtml";
    }
     
  
    public String redirectToCompany() {
        return "/secured/company.xhtml?faces-redirect=true";
    }
     
    public String toCompany() {
        return "/secured/company.xhtml";
    }
     
}
