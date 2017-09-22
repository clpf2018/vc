/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

/**
 *
 * @author Khalil Bsaibes
 */
import StockManagement.ObjectModel.ValueObject.User;
import StockManagement.Services.companyClient;
import StockManagement.Services.userClient;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class UserManager {

   // private static final Logger LOGGER = LoggerFactory
    //        .getLogger(UserManager.class);

    // public static final String HOME_PAGE_REDIRECT = "/secured/company.xhtml?faces-redirect=true";
    // public static final String LOGOUT_PAGE_REDIRECT = "/logout.xhtml?faces-redirect=true";
    private String username;
    private String userPassword;
    private User currentUser;
    
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;

     public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
    public String login() {
        // lookup the user based on user name and user password
        currentUser = find(username, userPassword);

        if (currentUser != null) {
            //LOGGER.info("login successful for '{}'", username);

            return navigationBean.redirectToHome();
        } else {
            //LOGGER.info("login failed for '{}'", username);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Login failed",
                            "Invalid or unknown credentials."));

            return null;
        }
    }

    public String logout() {
        String identifier = username;

        // invalidate the session
        //LOGGER.debug("invalidating session for '{}'", identifier);
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();

        //LOGGER.info("logout successful for '{}'", identifier);
        return navigationBean.redirectToLogout();
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public String isLoggedInForwardHome() {
        if (isLoggedIn()) {
            return navigationBean.redirectToHome();
        }

        return null;
    }

    private User find(String userId, String password) {
        User result = new User();
        userClient client = new userClient();
        result.setUsrUsername(userId);
        result.setUsrPassword(password);

        result = client.login(result, User.class);
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usernam) {
        this.username = usernam;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // do not provide a setter for currentUser!
}
