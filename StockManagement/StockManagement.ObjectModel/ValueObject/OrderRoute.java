/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.ValueObject;

import StockManagement.ObjectModel.Utilities.Endpoint;
import java.io.Serializable;

/**
 *
 * @author mfaour
 */
public class OrderRoute implements Serializable {
    private int code;
    private Endpoint route;

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the route
     */
    public Endpoint getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(Endpoint route) {
        this.route = route;
    }
    
    
}
