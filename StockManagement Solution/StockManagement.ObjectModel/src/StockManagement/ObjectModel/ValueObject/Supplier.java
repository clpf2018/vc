/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.ValueObject;


import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Elie
 */
public class Supplier  implements java.io.Serializable {


     private Integer supCode;
     private String supName;
     private String supTel;
     private String supMobile;
     private String supAddress;
     private String supEmail;
     private Set products = new HashSet(0);

    public Supplier() {
    }

    public Supplier(String supName, String supTel, String supMobile, String supAddress, String supEmail, Set products) {
       this.supName = supName;
       this.supTel = supTel;
       this.supMobile = supMobile;
       this.supAddress = supAddress;
       this.supEmail = supEmail;
       this.products = products;
    }
   
    public Integer getSupCode() {
        return this.supCode;
    }
    
    public void setSupCode(Integer supCode) {
        this.supCode = supCode;
    }
    public String getSupName() {
        return this.supName;
    }
    
    public void setSupName(String supName) {
        this.supName = supName;
    }
    public String getSupTel() {
        return this.supTel;
    }
    
    public void setSupTel(String supTel) {
        this.supTel = supTel;
    }
    public String getSupMobile() {
        return this.supMobile;
    }
    
    public void setSupMobile(String supMobile) {
        this.supMobile = supMobile;
    }
    public String getSupAddress() {
        return this.supAddress;
    }
    
    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }
    public String getSupEmail() {
        return this.supEmail;
    }
    
    public void setSupEmail(String supEmail) {
        this.supEmail = supEmail;
    }
    public Set getProducts() {
        return this.products;
    }
    
    public void setProducts(Set products) {
        this.products = products;
    }




}
