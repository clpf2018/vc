/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Utilities;

import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author mfaour
 */
public class MessageView {

    public static void Info(String title, String message) {
        FacesMessage fmessage = new FacesMessage(FacesMessage.SEVERITY_INFO, title, message);
        RequestContext.getCurrentInstance().showMessageInDialog(fmessage);
    }
    
    public static void Error(String title, String message) {
        FacesMessage fmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message);
        RequestContext.getCurrentInstance().showMessageInDialog(fmessage);
    }
    
    public static void Warn(String title, String message) {
        FacesMessage fmessage = new FacesMessage(FacesMessage.SEVERITY_WARN, title, message);
        RequestContext.getCurrentInstance().showMessageInDialog(fmessage);
    }
    
}
