/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.ValueObject;

/**
 *
 * @author Firas
 */
public class UserBranch implements java.io.Serializable{
    private int userCode;
    private int brCode;

    /**
     * @return the userCode
     */
    public int getUserCode() {
        return userCode;
    }

    /**
     * @param userCode the userCode to set
     */
    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    /**
     * @return the brCode
     */
    public int getBrCode() {
        return brCode;
    }

    /**
     * @param brCode the brCode to set
     */
    public void setBrCode(int brCode) {
        this.brCode = brCode;
    }
    
    
}
