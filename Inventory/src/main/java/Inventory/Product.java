/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

/**
 *
 * @author joseph
 */
public class Product {
    
   private int ID;
   private String code;
   private String Name;
   private Boolean Can_Be_Sold;
   private Boolean Can_Be_Purshased;
   private Product_Type Type;
   private Product_Category Category;
   private Barcode Bar;
   private double Sale_price;
   private double Cost;
   private Unit mesure;
   private Location Loc;
   
    public Product(String code, String Name, Boolean Can_Be_Sold, Boolean Can_Be_Purshased, Product_Type Type, Product_Category Category, Barcode Bar, double Sale_price, double Cost, Unit mesure) {
        this.code = code;
        this.Name = Name;
        this.Can_Be_Sold = Can_Be_Sold;
        this.Can_Be_Purshased = Can_Be_Purshased;
        this.Type = Type;
        this.Category = Category;
        this.Bar = Bar;
        this.Sale_price = Sale_price;
        this.Cost = Cost;
        this.mesure = mesure;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }
    
    public String getCode(){
        return this.code;
    }
    
      public Location getLocation() {
        return Loc;
    }

    public void setLocation(Location Loc){
        this.Loc=Loc;
    }

    public Boolean getCan_Be_Sold() {
        return Can_Be_Sold;
    }

    public Boolean getCan_Be_Purshased() {
        return Can_Be_Purshased;
    }

    public Product_Type getType() {
        return Type;
    }

    public Product_Category getCategory() {
        return Category;
    }

    public Barcode getBar() {
        return Bar;
    }

    public double getSale_price() {
        return Sale_price;
    }

    public double getCost() {
        return Cost;
    }

    public Unit getMesure() {
        return mesure;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
    public void setcode(String code){
        this.code=code;
    }
    public void setCan_Be_Sold(Boolean Can_Be_Sold) {
        this.Can_Be_Sold = Can_Be_Sold;
    }

    public void setCan_Be_Purshased(Boolean Can_Be_Purshased) {
        this.Can_Be_Purshased = Can_Be_Purshased;
    }

    public void setType(Product_Type Type) {
        this.Type = Type;
    }

    public void setCategory(Product_Category Category) {
        this.Category = Category;
    }

    public void setBar(Barcode Bar) {
        this.Bar = Bar;
    }

    public void setSale_price(double Sale_price) {
        this.Sale_price = Sale_price;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public void setMesure(Unit mesure) {
        this.mesure = mesure;
    }
    
}
